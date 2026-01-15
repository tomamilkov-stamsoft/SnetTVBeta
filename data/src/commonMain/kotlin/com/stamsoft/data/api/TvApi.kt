package com.stamsoft.data.api

import com.stamsoft.data.dto.ProgramDto

interface TvApi {
    suspend fun getSchedule(channelId: String, date: String): List<ProgramDto>
}
