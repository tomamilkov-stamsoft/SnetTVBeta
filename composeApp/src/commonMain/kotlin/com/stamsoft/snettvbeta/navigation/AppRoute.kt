package com.stamsoft.snettvbeta.navigation

sealed interface AppRoute {
    data object Main : AppRoute
    data object Schedule : AppRoute
}
