package com.stamsoft.androidtv.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed interface TvRoute : NavKey {
    @Serializable
    data object Main : TvRoute

    @Serializable
    data object Schedule : TvRoute
}
