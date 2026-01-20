package com.stamsoft.snettvbeta.schedule

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import snettvbeta.composeapp.generated.resources.Res
import snettvbeta.composeapp.generated.resources.error_with_message
import snettvbeta.composeapp.generated.resources.no_programs
import com.stamsoft.presentation.schedule.ScheduleState
import org.jetbrains.compose.resources.stringResource

@Composable
fun ScheduleContent(state: ScheduleState) {
    when {
        state.isLoading -> CircularProgressIndicator()
        state.error != null -> Text(
            stringResource(Res.string.error_with_message, state.error.orEmpty()),
            color = MaterialTheme.colorScheme.error
        )
        state.programs.isEmpty() -> Text(stringResource(Res.string.no_programs))
        else -> ProgramList(state.programs)
    }
}
