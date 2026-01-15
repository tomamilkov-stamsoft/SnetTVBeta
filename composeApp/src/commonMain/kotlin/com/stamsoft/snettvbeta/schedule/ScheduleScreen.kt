package com.stamsoft.snettvbeta.schedule

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.stamsoft.presentation.actions.ScheduleAction
import com.stamsoft.presentation.states.ScheduleState
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock

@Composable
fun ScheduleScreen(
    state: ScheduleState,
    onAction: (ScheduleAction) -> Unit,
    modifier: Modifier = Modifier
) {
    LaunchedEffect(Unit) {
        val today = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date
        onAction(ScheduleAction.LoadSchedule("test-channel", today))
    }

    DisposableEffect(Unit) {
        onDispose { onAction(ScheduleAction.Clear) }
    }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        ScheduleContent(state = state)
    }
}
