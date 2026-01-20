package com.stamsoft.snettvbeta.schedule

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.stamsoft.presentation.schedule.ScheduleState

@Composable
fun ScheduleContent(state: ScheduleState) {
    when {
        state.isLoading -> CircularProgressIndicator()
        state.error != null -> Text("Error: ${state.error}", color = MaterialTheme.colorScheme.error)
        state.programs.isEmpty() -> Text("No programs available")
        else -> ProgramList(state.programs)
    }
}
