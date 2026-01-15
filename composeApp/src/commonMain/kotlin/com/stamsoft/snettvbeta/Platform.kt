package com.stamsoft.snettvbeta

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform