package com.stamsoft.snettvbeta

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.stamsoft.domain.model.Program
import com.stamsoft.presentation.viewmodel.ScheduleViewModel
import com.stamsoft.snettvbeta.util.toHourMinute
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock
import org.koin.compose.koinInject

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScheduleScreen(
    onBack: () -> Unit,
    viewModel: ScheduleViewModel = koinInject()
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        val today = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date
        viewModel.loadSchedule("test-channel", today)
    }

    DisposableEffect(viewModel) {
        onDispose { viewModel.clear() }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("TV Schedule") },
                navigationIcon = {
                    Button(onClick = onBack) {
                        Text("Back")
                    }
                }
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {
            when {
                state.isLoading -> CircularProgressIndicator()
                state.error != null -> Text("Error: ${state.error}", color = MaterialTheme.colorScheme.error)
                state.programs.isEmpty() -> Text("No programs available")
                else -> ProgramList(state.programs)
            }
        }
    }
}

@Composable
fun ProgramList(programs: List<Program>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(programs, key = { it.id }) { program ->
            ProgramItem(program)
        }
    }
}

@Composable
fun ProgramItem(program: Program) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = program.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "${program.startTime.toHourMinute()} - ${program.endTime.toHourMinute()}",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = program.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
