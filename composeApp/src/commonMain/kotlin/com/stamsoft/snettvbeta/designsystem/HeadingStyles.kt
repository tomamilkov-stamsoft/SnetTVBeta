package com.stamsoft.snettvbeta.designsystem

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign

@Composable
fun H1(
    text: String,
    color: Color = LocalDSTheme.current.colors.base0,
    brush: Brush? = null,
    textAlign: TextAlign? = null,
    fontFamily: FontFamily = FontFamily.Default,
) {
    Text(
        text = text,
        fontSize = FontSizeTokens.font_size_250,
        fontWeight = LineWeightTokens.line_weight_250,
        color = color,
        fontFamily = fontFamily,
        lineHeight = LineHeightTokens.line_height_250,
        textAlign = textAlign,
        style = brush?.let { TextStyle(brush = it) } ?: TextStyle() // if text is gradient
    )
}

@Composable
fun H2(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = LocalDSTheme.current.colors.base0,
    textAlign: TextAlign? = null,
    fontFamily: FontFamily = FontFamily.Default,
) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = FontSizeTokens.font_size_200,
        fontWeight = LineWeightTokens.line_weight_250,
        color = color,
        fontFamily = fontFamily,
        textAlign = textAlign,
    )
}


@Composable
fun H3(
    text: String,
    color: Color = LocalDSTheme.current.colors.base0,
    textAlign: TextAlign? = null,
    fontFamily: FontFamily = FontFamily.Default,
) {
    Text(
        text = text,
        fontSize = FontSizeTokens.font_size_150,
        fontWeight = LineWeightTokens.line_weight_250,
        color = color,
        fontFamily = fontFamily,
        textAlign = textAlign,
    )
}


@Composable
fun H4(
    text: String,
    color: Color = LocalDSTheme.current.colors.base0,
    textAlign: TextAlign? = null,
    fontFamily: FontFamily = FontFamily.Default,
) {
    Text(
        text = text,
        fontSize = FontSizeTokens.font_size_250,
        fontWeight = LineWeightTokens.line_weight_250,
        lineHeight = LineHeightTokens.line_height_300,
        color = color,
        fontFamily = fontFamily,
        textAlign = textAlign,
    )
}


@Composable
fun H5(
    text: String,
    color: Color = LocalDSTheme.current.colors.base0,
    textAlign: TextAlign? = null,
    fontFamily: FontFamily = FontFamily.Default,
) {
    Text(
        text = text,
        fontSize = FontSizeTokens.font_size_200,
        fontWeight = LineWeightTokens.line_weight_250,
        lineHeight = LineHeightTokens.line_height_250,
        color = color,
        fontFamily = fontFamily,
        textAlign = textAlign,
    )
}

@Composable
fun H6(
    text: String,
    color: Color = LocalDSTheme.current.colors.base0,
    textAlign: TextAlign? = null,
    fontFamily: FontFamily = FontFamily.Default,
) {
    Text(
        text = text,
        fontSize = FontSizeTokens.font_size_200,
        fontWeight = LineWeightTokens.line_weight_250,
        lineHeight = LineHeightTokens.line_height_200,
        color = color,
        fontFamily = fontFamily,
        textAlign = textAlign,
    )
}
