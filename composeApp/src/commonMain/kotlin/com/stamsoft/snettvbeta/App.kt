package com.stamsoft.snettvbeta

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview

enum class Screen {
    Main, Schedule
}

@Composable
@Preview
fun App() {
    MaterialTheme {
        var currentScreen by remember { mutableStateOf(Screen.Main) }

        Box(modifier = Modifier.fillMaxSize()) {
            when (currentScreen) {
                Screen.Main -> MainScreen(onNavigateToSchedule = { currentScreen = Screen.Schedule })
                Screen.Schedule -> ScheduleScreen(onBack = { currentScreen = Screen.Main })
            }
        }
    }
}

@Composable
fun MainScreen(onNavigateToSchedule: () -> Unit) {
    Box(
        modifier = Modifier
            .safeContentPadding()
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = onNavigateToSchedule) {
            Text("Click me!")
        }
    }
}
