package com.stamsoft.androidtv.utils

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock

fun currentLocalDate() =
    Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date

fun formatTimeOfDay(time: LocalDateTime): String {
    val hour = time.hour.toString().padStart(2, '0')
    val minute = time.minute.toString().padStart(2, '0')
    return "$hour:$minute"
}
