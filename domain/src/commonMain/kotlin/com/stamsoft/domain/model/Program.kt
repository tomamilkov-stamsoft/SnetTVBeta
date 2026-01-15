package com.stamsoft.domain.model

import kotlinx.datetime.LocalDateTime

data class Program(
    val id: String,
    val title: String,
    val description: String,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime,
    val imageUrl: String? = null,
    val channelId: String
)
