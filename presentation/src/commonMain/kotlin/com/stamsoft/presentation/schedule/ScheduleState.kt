package com.stamsoft.presentation.schedule

import com.stamsoft.domain.model.Program

data class ScheduleState(
    val isLoading: Boolean = false,
    val programs: List<Program> = emptyList(),
    val error: String? = null
)
