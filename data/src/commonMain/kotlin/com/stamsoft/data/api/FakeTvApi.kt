package com.stamsoft.data.api

import com.stamsoft.data.dto.ProgramDto
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime

class FakeTvApi : TvApi {
    override suspend fun getSchedule(channelId: String, date: String): List<ProgramDto> {
        val baseDate = LocalDate.parse(date)
        return listOf(
            ProgramDto(
                id = "1",
                title = "Morning News",
                description = "Daily news summary.",
                startTime = LocalDateTime(
                    year = baseDate.year,
                    monthNumber = baseDate.monthNumber,
                    dayOfMonth = baseDate.dayOfMonth,
                    hour = 8,
                    minute = 0
                ).toString(),
                endTime = LocalDateTime(
                    year = baseDate.year,
                    monthNumber = baseDate.monthNumber,
                    dayOfMonth = baseDate.dayOfMonth,
                    hour = 9,
                    minute = 0
                ).toString(),
                imageUrl = "https://example.com/news.jpg",
                channelId = channelId
            ),
            ProgramDto(
                id = "2",
                title = "Cooking Show",
                description = "Learn to cook delicious meals.",
                startTime = LocalDateTime(
                    year = baseDate.year,
                    monthNumber = baseDate.monthNumber,
                    dayOfMonth = baseDate.dayOfMonth,
                    hour = 9,
                    minute = 0
                ).toString(),
                endTime = LocalDateTime(
                    year = baseDate.year,
                    monthNumber = baseDate.monthNumber,
                    dayOfMonth = baseDate.dayOfMonth,
                    hour = 10,
                    minute = 30
                ).toString(),
                imageUrl = "https://example.com/cooking.jpg",
                channelId = channelId
            ),
            ProgramDto(
                id = "3",
                title = "Evening Movie",
                description = "A blockbuster movie for the whole family.",
                startTime = LocalDateTime(
                    year = baseDate.year,
                    monthNumber = baseDate.monthNumber,
                    dayOfMonth = baseDate.dayOfMonth,
                    hour = 20,
                    minute = 0
                ).toString(),
                endTime = LocalDateTime(
                    year = baseDate.year,
                    monthNumber = baseDate.monthNumber,
                    dayOfMonth = baseDate.dayOfMonth,
                    hour = 22,
                    minute = 30
                ).toString(),
                imageUrl = "https://example.com/movie.jpg",
                channelId = channelId
            )
        )
    }
}
