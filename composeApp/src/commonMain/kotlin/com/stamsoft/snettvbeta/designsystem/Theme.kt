package com.stamsoft.snettvbeta.designsystem

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

// Change the color values in Colors.kt
val Primary1 = Color(0xFFC5416D)
val Primary2 = Color(0xFFE2A0B6)
val Secondary1 = Color(0xFF7C7CCD)
val Secondary2 = Color(0xFFCBCBEB)
val Tertiary1 = Color(0xFF15B9D1)
val Tertiary2 = Color(0xFFA1E3ED)
val AlertPrimary = Color(0xFFC5416D)
val AlertSecondary = Color(0xFFEEC6D3)
val SuccessPrimary = Color(0xFF15B9D1)
val SuccessSecondary = Color(0xFFB9EAF1)
val CautionPrimary = Color(0xFF7C7CCD)
val CautionSecondary = Color(0xFFD8D8F0)
val Base100 = Color(0xFF222222)
val Base90 = Color(0xFF2D2D2D)
val Base85 = Color(0xFF393939)
val Base80 = Color(0xFF4E4E4E)
val Base60 = Color(0xFF7A7A7A)
val Base40 = Color(0xFFA7A7A7)
val Base20 = Color(0xFFD3D3D3)
val Base0 = Color(0xFFFFFFFF)
val MainGradient = Brush.linearGradient(listOf(Primary1, Secondary1, Tertiary1))

// Create a class with all used colors for your theme
data class Colors(
    var background: Color,
    val primary1: Color,
    val primary2: Color,
    val secondary1: Color,
    val secondary2: Color,
    val tertiary1: Color,
    val tertiary2: Color,
    val alertPrimary: Color,
    val alertSecondary: Color,
    val successPrimary: Color,
    val successSecondary: Color,
    val cautionPrimary: Color,
    val cautionSecondary: Color,
    val base100: Color,
    val base90: Color,
    val base85: Color,
    val base80: Color,
    val base60: Color,
    val base40: Color,
    val base20: Color,
    val base0: Color,
    val mainGradient: Brush,
)

// Create a Theme class which defines the colors for both dark and light theme
private val DSLightImpl = Colors(
    background = Base100,
    primary1 = Primary1,
    primary2 = Primary2,
    secondary1 = Secondary1,
    secondary2 = Secondary2,
    tertiary1 = Tertiary1,
    tertiary2 = Tertiary2,
    alertPrimary = AlertPrimary,
    alertSecondary = AlertSecondary,
    successPrimary = SuccessPrimary,
    successSecondary = SuccessSecondary,
    cautionPrimary = CautionPrimary,
    cautionSecondary = CautionSecondary,
    base100 = Base100,
    base90 = Base90,
    base85 = Base85,
    base80 = Base80,
    base60 = Base60,
    base40 = Base40,
    base20 = Base20,
    base0 = Base0,
    mainGradient = MainGradient
)

private val DSDarkImpl = Colors(
    background = Base100,
    primary1 = Primary1,
    primary2 = Primary2,
    secondary1 = Secondary1,
    secondary2 = Secondary2,
    tertiary1 = Tertiary1,
    tertiary2 = Tertiary2,
    alertPrimary = AlertPrimary,
    alertSecondary = AlertSecondary,
    successPrimary = SuccessPrimary,
    successSecondary = SuccessSecondary,
    cautionPrimary = CautionPrimary,
    cautionSecondary = CautionSecondary,
    base100 = Base100,
    base90 = Base90,
    base85 = Base85,
    base80 = Base80,
    base60 = Base60,
    base40 = Base40,
    base20 = Base20,
    base0 = Base0,
    mainGradient = MainGradient
)

private val DSDarkMaterialColors = darkColorScheme(
    primary = DSDarkImpl.primary1,
    secondary = DSDarkImpl.secondary1,
    tertiary = DSDarkImpl.tertiary1,
    background = DSDarkImpl.base100,
    onBackground = DSDarkImpl.base80,
    onSecondary = DSDarkImpl.base60,
    onPrimaryContainer = DSDarkImpl.base40,
    surface = DSDarkImpl.base20
)

private val DSLightMaterialColors = lightColorScheme(
    primary = DSLightImpl.primary1,
    secondary = DSLightImpl.secondary1,
    tertiary = DSLightImpl.tertiary1,
    background = DSLightImpl.base100,
    onBackground = DSLightImpl.base80,
    onSecondary = DSLightImpl.base60,
    onPrimaryContainer = DSLightImpl.base40,
    surface = DSLightImpl.base20
)

val DSThemeLight = DSTheme(
    colors = DSLightImpl
)

val DSMainThemeDark = DSTheme(
    colors = DSDarkImpl
)

@Composable
fun SnetTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
    lightColors: Colors? = null,
    darkColors: Colors? = null,
) {
    val colors = when {
        darkTheme && darkColors != null -> darkColors
        !darkTheme && lightColors != null -> lightColors
        darkTheme -> DSDarkImpl
        else -> DSLightImpl
    }

    val colorScheme = if (darkTheme) {
        darkColors?.toColorScheme() ?: DSDarkMaterialColors
    } else {
        lightColors?.toColorScheme() ?: DSLightMaterialColors
    }

    DSThemeProvider(DSTheme(colors)) {
        MaterialTheme(
            colorScheme = colorScheme,
            content = content
        )
    }
}

// Create a ThemeProvider where val for getting the colors
@Composable
fun DSThemeProvider(
    dsTheme: DSTheme,
    content: @Composable () -> Unit,
) {
    val theme by rememberUpdatedState(dsTheme)
    CompositionLocalProvider(LocalDSTheme provides theme, content = content)
}

val LocalDSTheme = staticCompositionLocalOf {
    // Default value
    DSMainThemeDark
}


@Stable
class DSTheme(
    colors: Colors,
) {
    var colors by mutableStateOf(colors)
        private set

    fun update(other: DSTheme) {
        colors = other.colors
    }
}

fun Colors.toColorScheme(): ColorScheme {
    return lightColorScheme(
        primary = primary1,
        secondary = secondary1,
        tertiary = tertiary1,
        background = base100,
        onBackground = base80,
        onSecondary = base60,
        onPrimaryContainer = base40,
        surface = base20
    )
}
