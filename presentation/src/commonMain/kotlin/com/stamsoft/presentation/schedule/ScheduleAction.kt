package com.stamsoft.presentation.schedule

import kotlinx.datetime.LocalDate

sealed interface ScheduleAction {
    data class LoadSchedule(val channelId: String, val date: LocalDate) : ScheduleAction
}
