package com.stamsoft.androidtv.schedule

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import com.stamsoft.androidtv.utils.currentLocalDate
import com.stamsoft.presentation.schedule.ScheduleAction
import com.stamsoft.presentation.schedule.ScheduleState

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun TvScheduleScreen(
    state: ScheduleState,
    onAction: (ScheduleAction) -> Unit
) {
    LaunchedEffect(Unit) {
        onAction(ScheduleAction.LoadSchedule("test-channel", currentLocalDate()))
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TvScheduleHeader(
            title = "Schedule",
            onReload = { onAction(ScheduleAction.LoadSchedule("test-channel", currentLocalDate())) }
        )

        when {
            state.isLoading -> {
                Text("Loading...")
            }
            state.error != null -> {
                Text("Error: ${state.error}")
            }
            else -> {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(state.programs) { program ->
                        TvProgramRow(program = program)
                    }
                }
            }
        }
    }
}
