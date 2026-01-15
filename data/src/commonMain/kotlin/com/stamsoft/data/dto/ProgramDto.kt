package com.stamsoft.data.dto

import com.stamsoft.domain.model.Program
import kotlinx.datetime.LocalDateTime

data class ProgramDto(
    val id: String,
    val title: String,
    val description: String,
    val startTime: String,
    val endTime: String,
    val imageUrl: String?,
    val channelId: String
)

fun ProgramDto.toDomain(): Program {
    return Program(
        id = id,
        title = title,
        description = description,
        startTime = LocalDateTime.parse(startTime),
        endTime = LocalDateTime.parse(endTime),
        imageUrl = imageUrl,
        channelId = channelId
    )
}
