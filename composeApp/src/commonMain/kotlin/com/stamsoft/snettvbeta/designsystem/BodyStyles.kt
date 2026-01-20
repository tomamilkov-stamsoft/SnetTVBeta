package com.stamsoft.snettvbeta.designsystem

// Body styles from the Design Systems. If any new are added feel free to add in the file.

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign

@Composable
fun Body1Bold(
    text: String,
    color: Color = LocalDSTheme.current.colors.base0,
    textAlign: TextAlign? = null,
    fontFamily: FontFamily = FontFamily.Default,
) {
    Text(
        text = text,
        fontSize = FontSizeTokens.font_size_100,
        fontWeight = LineWeightTokens.line_weight_150,
        fontFamily = fontFamily,
        color = color,
        textAlign = textAlign,
    )
}

@Composable
fun Body1BoldCaps(
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
        fontFamily = fontFamily,
        color = color,
        textAlign = textAlign,
    )
}

@Composable
fun Body1Medium(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = LocalDSTheme.current.colors.base0,
    textAlign: TextAlign? = null,
    fontFamily: FontFamily = FontFamily.Default,
) {
    Text(
        text = text,
        fontSize = FontSizeTokens.font_size_100,
        fontWeight = LineWeightTokens.line_weight_150,
        color = color,
        modifier = modifier,
        textAlign = textAlign,
        fontFamily = fontFamily,
    )
}

@Composable
fun Body1Regular(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = LocalDSTheme.current.colors.base0,
    brush: Brush? = null, // if text is gradient
    textAlign: TextAlign? = null,
    fontFamily: FontFamily = FontFamily.Default,
) {
    Text(
        text = text,
        fontSize = FontSizeTokens.font_size_100,
        fontWeight = LineWeightTokens.line_weight_100,
        color = color,
        modifier = modifier,
        fontFamily = fontFamily,
        textAlign = textAlign,
        style = brush?.let { TextStyle(brush = it) } ?: TextStyle()
    )
}


@Composable
fun Body2Regular(
    text: String,
    color: Color = LocalDSTheme.current.colors.base0,
    textAlign: TextAlign? = null,
    fontFamily: FontFamily = FontFamily.Default,
) {
    Text(
        text = text,
        fontSize = FontSizeTokens.font_size_50,
        fontWeight = LineWeightTokens.line_weight_100,
        lineHeight = LineHeightTokens.line_height_100,
        color = color,
        fontFamily = fontFamily,
        textAlign = textAlign,
    )
}
