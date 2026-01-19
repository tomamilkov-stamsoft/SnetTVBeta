package com.stamsoft.snettvbeta.navigation

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
import com.stamsoft.presentation.viewmodel.ScheduleViewModel
import com.stamsoft.snettvbeta.MainScreen
import com.stamsoft.snettvbeta.schedule.ScheduleScreen
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import org.koin.compose.koinInject

@Composable
fun NavigationRoot(
    modifier: Modifier = Modifier
) {
    val navConfiguration = remember {
        SavedStateConfiguration {
            serializersModule = SerializersModule {
                polymorphic(NavKey::class) {
                    subclass(AppRoute.Main::class, AppRoute.Main.serializer())
                    subclass(AppRoute.Schedule::class, AppRoute.Schedule.serializer())
                }
            }
        }
    }
    val backStack = rememberNavBackStack(navConfiguration, AppRoute.Main)
    NavDisplay(
        modifier = modifier,
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { key ->
            when (key) {
                is AppRoute.Main -> NavEntry(key) {
                    MainScreen(
                        onNavigateToSchedule = { backStack.add(AppRoute.Schedule) }
                    )
                }

                is AppRoute.Schedule -> NavEntry(key) {
                    val viewModel: ScheduleViewModel = koinInject()
                    val state by viewModel.state.collectAsState()
                    ScheduleScreen(
                        state = state,
                        onAction = viewModel::sendAction
                    )
                }
                else -> error("Unknown route: $key")
            }
        }
    )
}
