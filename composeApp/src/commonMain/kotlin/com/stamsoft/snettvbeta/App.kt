package com.stamsoft.snettvbeta

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.stamsoft.presentation.viewmodel.ScheduleViewModel
import com.stamsoft.snettvbeta.navigation.AppRoute
import com.stamsoft.snettvbeta.schedule.ScheduleScreen
import org.koin.compose.koinInject

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    AppTheme {
        val backStack = remember { mutableStateListOf<Any>(AppRoute.Main) }
        val current = backStack.last()
        val isSchedule = current is AppRoute.Schedule

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(if (isSchedule) "Schedule" else "Main") },
                    navigationIcon = {
                        if (isSchedule) {
                            Button(onClick = { backStack.removeLastOrNull() }) {
                                Text("Back")
                            }
                        }
                    }
                )
            }
        ) { padding ->
            NavDisplay(
                backStack = backStack,
                onBack = { backStack.removeLastOrNull() },
                entryProvider = { key ->
                    when (key) {
                        is AppRoute.Main -> NavEntry(key) {
                            MainScreen(
                                onNavigateToSchedule = { backStack.add(AppRoute.Schedule) },
                                modifier = Modifier.padding(padding)
                            )
                        }

                        is AppRoute.Schedule -> NavEntry(key) {
                            val viewModel: ScheduleViewModel = koinInject()
                            val state by viewModel.state.collectAsState()
                            ScheduleScreen(
                                state = state,
                                onAction = viewModel::sendAction,
                                modifier = Modifier.padding(padding)
                            )
                        }

                        else -> error("Unknown route: $key")
                    }
                }
            )
        }
    }
}
