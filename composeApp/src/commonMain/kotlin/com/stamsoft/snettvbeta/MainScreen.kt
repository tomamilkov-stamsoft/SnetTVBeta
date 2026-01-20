package com.stamsoft.snettvbeta

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.stamsoft.snettvbeta.designsystem.LocalDSTheme
import com.stamsoft.snettvbeta.designsystem.PrimaryButton
import snettvbeta.composeapp.generated.resources.Res
import snettvbeta.composeapp.generated.resources.main_cta
import org.jetbrains.compose.resources.stringResource

@Composable
fun MainScreen(
    onNavigateToSchedule: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LocalDSTheme.current.colors.base0),
        contentAlignment = Alignment.Center
    ) {
        PrimaryButton(
            text = stringResource(Res.string.main_cta),
            onClick = onNavigateToSchedule,
        )
    }
}
