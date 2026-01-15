package com.stamsoft.domain.repository

import com.stamsoft.domain.model.Program
import kotlinx.datetime.LocalDate

interface ScheduleRepository {
    suspend fun getSchedule(channelId: String, date: LocalDate): List<Program>
}
