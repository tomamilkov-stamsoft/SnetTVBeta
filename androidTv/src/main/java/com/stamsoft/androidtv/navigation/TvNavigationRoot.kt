package com.stamsoft.androidtv.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import com.stamsoft.androidtv.MainScreen
import com.stamsoft.androidtv.schedule.TvScheduleScreen
import com.stamsoft.presentation.schedule.ScheduleViewModel
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import org.koin.androidx.compose.koinViewModel

@Composable
fun TvNavigationRoot(
    modifier: Modifier = Modifier
) {
    val navConfiguration = remember {
        SavedStateConfiguration {
            serializersModule = SerializersModule {
                polymorphic(NavKey::class) {
                    subclass(TvRoute.Main::class, TvRoute.Main.serializer())
                    subclass(TvRoute.Schedule::class, TvRoute.Schedule.serializer())
                }
            }
        }
    }
    val backStack = rememberNavBackStack(navConfiguration, TvRoute.Main)
    NavDisplay(
        modifier = modifier,
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { key ->
            when (key) {
                is TvRoute.Main -> NavEntry(key) {
                    MainScreen(
                        onNavigateToSchedule = { backStack.add(TvRoute.Schedule) }
                    )
                }

                is TvRoute.Schedule -> NavEntry(key) {
                    val viewModel: ScheduleViewModel = koinViewModel()
                    val state by viewModel.state.collectAsState()
                    TvScheduleScreen(
                        state = state,
                        onAction = viewModel::sendAction
                    )
                }
                else -> error("Unknown route: $key")
            }
        }
    )
}
