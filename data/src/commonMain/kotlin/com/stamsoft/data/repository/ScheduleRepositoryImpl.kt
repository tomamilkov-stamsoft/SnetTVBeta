package com.stamsoft.data.repository

import com.stamsoft.data.api.TvApi
import com.stamsoft.data.dto.toDomain
import com.stamsoft.domain.model.Program
import com.stamsoft.domain.repository.ScheduleRepository
import kotlinx.datetime.LocalDate

class ScheduleRepositoryImpl(private val api: TvApi) : ScheduleRepository {
    override suspend fun getSchedule(channelId: String, date: LocalDate): List<Program> {
        return api.getSchedule(channelId, date.toString()).map { it.toDomain() }
    }
}
