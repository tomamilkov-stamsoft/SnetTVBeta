package com.stamsoft.presentation.actions

import kotlinx.datetime.LocalDate

sealed interface ScheduleAction {
    data class LoadSchedule(val channelId: String, val date: LocalDate) : ScheduleAction
}
