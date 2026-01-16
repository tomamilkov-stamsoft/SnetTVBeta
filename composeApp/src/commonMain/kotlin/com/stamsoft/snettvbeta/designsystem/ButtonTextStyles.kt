package com.stamsoft.snettvbeta.designsystem

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration


@Composable
fun ButtonBold(
    text: String,
    color: Color = LocalDSTheme.current.colors.base0,
    textAlign: TextAlign? = null,
    fontFamily: FontFamily = FontFamily.Default,
) {
    Text(
        text = text,
        fontSize = FontSizeTokens.font_size_100,
        fontWeight = LineWeightTokens.line_weight_250,
        color = color,
        textAlign = textAlign,
        fontFamily = fontFamily,
    )
}

@Composable
fun ButtonRegular(
    text: String,
    color: Color = LocalDSTheme.current.colors.base0,
    textAlign: TextAlign? = null,
    fontFamily: FontFamily = FontFamily.Default,
) {
    Text(
        text = text,
        fontSize = FontSizeTokens.font_size_100,
        fontWeight = LineWeightTokens.line_weight_250,
        lineHeight = LineHeightTokens.line_height_100,
        color = color,
        textAlign = textAlign,
        fontFamily = fontFamily,
    )
}

@Composable
fun ButtonLink(
    text: String,
    color: Color = LocalDSTheme.current.colors.base0,
    textDecoration: TextDecoration = TextDecoration.Underline,
    textAlign: TextAlign? = null,
    fontFamily: FontFamily = FontFamily.Default,
) {
    Text(
        text = text,
        fontSize = FontSizeTokens.font_size_100,
        fontWeight = LineWeightTokens.line_weight_100,
        lineHeight = LineHeightTokens.line_height_100,
        color = color,
        textDecoration = textDecoration,
        textAlign = textAlign,
        fontFamily = fontFamily,
    )
}
