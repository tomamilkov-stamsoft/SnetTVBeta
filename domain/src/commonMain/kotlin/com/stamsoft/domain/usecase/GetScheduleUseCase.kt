package com.stamsoft.domain.usecase

import com.stamsoft.domain.model.Program
import com.stamsoft.domain.repository.ScheduleRepository
import kotlinx.datetime.LocalDate

class GetScheduleUseCase(private val repository: ScheduleRepository) {
    suspend operator fun invoke(channelId: String, date: LocalDate): List<Program> {
        return repository.getSchedule(channelId, date)
    }
}
