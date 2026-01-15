package com.stamsoft.snettvbeta.util

import kotlinx.datetime.LocalDateTime

fun LocalDateTime.toHourMinute(): String {
    val hour = this.hour.toString().padStart(2, '0')
    val minute = this.minute.toString().padStart(2, '0')
    return "$hour:$minute"
}
