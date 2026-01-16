package com.stamsoft.snettvbeta.designsystem

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp

val MIN_BUTTON_HEIGHT = 44.dp

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    fontFamily: FontFamily = FontFamily.Default,
) {
    val colors = Brush.linearGradient(
        listOf(
            LocalDSTheme.current.colors.primary1,
            LocalDSTheme.current.colors.secondary1,
            LocalDSTheme.current.colors.tertiary1,
        ),
    )

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(BorderRadiusToken.border_radius_300))
            .background(colors)
            .clickable(onClick = onClick)
            .heightIn(min = MIN_BUTTON_HEIGHT),
        contentAlignment = Alignment.Center
    ) {
        ButtonRegular(text, fontFamily = fontFamily)
    }
}

@Composable
fun ButtonWithIcon(
    text: String,
    painter: Painter,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    fontFamily: FontFamily = FontFamily.Default,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(BorderRadiusToken.border_radius_300))
            .background(LocalDSTheme.current.colors.base0)
            .clickable(onClick = onClick)
            .heightIn(min = MIN_BUTTON_HEIGHT),
        contentAlignment = Alignment.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painter,
                contentDescription = null,
            )

            Spacer(Modifier.width(SpaceTokens.spacing_200))

            ButtonRegular(text, fontFamily = fontFamily)
        }
    }
}
