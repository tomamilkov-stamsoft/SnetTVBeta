package com.stamsoft.presentation.schedule

import com.stamsoft.domain.model.Program
import com.stamsoft.domain.usecase.GetScheduleUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.datetime.LocalDate

class ScheduleViewModel(
    private val getScheduleUseCase: GetScheduleUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(ScheduleState())
    val state: StateFlow<ScheduleState> = _state.asStateFlow()

    fun sendAction(action: ScheduleAction) {
        when (action) {
            is ScheduleAction.LoadSchedule -> loadSchedule(action.channelId, action.date)
        }
    }

    private fun loadSchedule(channelId: String, date: LocalDate) {
        viewModelScope.launch {
            setLoading()
            try {
                val programs = getScheduleUseCase(channelId, date)
                setPrograms(programs)
            } catch (e: Exception) {
                setError(e.message ?: "An unexpected error occurred")
            }
        }
    }

    private fun setLoading() {
        _state.update { it.copy(isLoading = true, error = null) }
    }

    private fun setPrograms(programs: List<Program>) {
        _state.update { it.copy(isLoading = false, programs = programs, error = null) }
    }

    private fun setError(message: String) {
        _state.update { it.copy(isLoading = false, error = message) }
    }
}
