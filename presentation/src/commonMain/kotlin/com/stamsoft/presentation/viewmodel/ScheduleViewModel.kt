package com.stamsoft.presentation.viewmodel

import com.stamsoft.domain.usecase.GetScheduleUseCase
import com.stamsoft.presentation.states.ScheduleState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.datetime.LocalDate

class ScheduleViewModel(
    private val getScheduleUseCase: GetScheduleUseCase,
    private val scope: CoroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
) {

    private val _state = MutableStateFlow(ScheduleState())
    val state: StateFlow<ScheduleState> = _state.asStateFlow()

    fun loadSchedule(channelId: String, date: LocalDate) {
        scope.launch {
            _state.update { it.copy(isLoading = true, error = null) }
            try {
                val programs = getScheduleUseCase(channelId, date)
                _state.update { it.copy(isLoading = false, programs = programs) }
            } catch (e: Exception) {
                _state.update {
                    it.copy(
                        isLoading = false,
                        error = e.message ?: "An unexpected error occurred"
                    )
                }
            }
        }
    }

    fun clear() {
        scope.cancel()
    }
}
