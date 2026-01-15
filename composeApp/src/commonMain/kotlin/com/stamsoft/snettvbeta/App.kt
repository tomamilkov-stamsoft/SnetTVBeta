package com.stamsoft.snettvbeta

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.stamsoft.presentation.viewmodel.ScheduleViewModel
import com.stamsoft.snettvbeta.navigation.AppRoute
import org.koin.compose.koinInject

@Composable
fun App() {
    AppTheme {
        val backStack = remember { mutableStateListOf<Any>(AppRoute.Main) }

        NavDisplay(
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
                            onAction = viewModel::sendAction,
                            onBack = { backStack.removeLastOrNull() }
                        )
                    }

                    else -> error("Unknown route: $key")
                }
            }
        )
    }
}
