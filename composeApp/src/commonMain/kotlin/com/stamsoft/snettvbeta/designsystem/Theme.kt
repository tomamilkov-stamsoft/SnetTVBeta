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

// Design system colors
val Primary1 = Color(0xFFFFA696)
val Primary2 = Color(0xFFFFD6CF)
val Primary3 = Color(0xFFFF9785)
val PrimaryButton = Color(0xFFD2AB67)
val AlertPrimary = Color(0xFFFF4C4C)
val AlertSecondary = Color(0xFFFFC9C9)
val SuccessPrimary = Color(0xFF00E248)
val SuccessSecondary = Color(0xFFB2F6C8)
val CautionPrimary = Color(0xFFFFB03A)
val CautionSecondary = Color(0xFFFFDFB0)
val Base100 = Color(0xFF121212)
val Base80 = Color(0xFF252525)
val Base60 = Color(0xFF313131)
val Base40 = Color(0xFF575757)
val Base20 = Color(0xFFA0A0A0)
val Base10 = Color(0xFFCACACA)
val Base5 = Color(0xFFE2E2E2)
val Base0 = Color(0xFFFFFFFF)
val BaseGradient = Brush.linearGradient(listOf(Base100, Base0))
val PrimaryGradient = Brush.linearGradient(listOf(Color(0xFFD2AB67), Color(0xFFBE985A)))

// Create a class with all used colors for your theme
data class Colors(
    var background: Color,
    val primary1: Color,
    val primary2: Color,
    val primary3: Color,
    val primaryButton: Color,
    val alertPrimary: Color,
    val alertSecondary: Color,
    val successPrimary: Color,
    val successSecondary: Color,
    val cautionPrimary: Color,
    val cautionSecondary: Color,
    val base100: Color,
    val base80: Color,
    val base60: Color,
    val base40: Color,
    val base20: Color,
    val base10: Color,
    val base5: Color,
    val base0: Color,
    val baseGradient: Brush,
    val primaryGradient: Brush,
)

// Create a Theme class which defines the colors for both dark and light theme
private val DSLightImpl = Colors(
    background = Base100,
    primary1 = Primary1,
    primary2 = Primary2,
    primary3 = Primary3,
    primaryButton = PrimaryButton,
    alertPrimary = AlertPrimary,
    alertSecondary = AlertSecondary,
    successPrimary = SuccessPrimary,
    successSecondary = SuccessSecondary,
    cautionPrimary = CautionPrimary,
    cautionSecondary = CautionSecondary,
    base100 = Base100,
    base80 = Base80,
    base60 = Base60,
    base40 = Base40,
    base20 = Base20,
    base10 = Base10,
    base5 = Base5,
    base0 = Base0,
    baseGradient = BaseGradient,
    primaryGradient = PrimaryGradient
)

private val DSDarkImpl = Colors(
    background = Base100,
    primary1 = Primary1,
    primary2 = Primary2,
    primary3 = Primary3,
    primaryButton = PrimaryButton,
    alertPrimary = AlertPrimary,
    alertSecondary = AlertSecondary,
    successPrimary = SuccessPrimary,
    successSecondary = SuccessSecondary,
    cautionPrimary = CautionPrimary,
    cautionSecondary = CautionSecondary,
    base100 = Base100,
    base80 = Base80,
    base60 = Base60,
    base40 = Base40,
    base20 = Base20,
    base10 = Base10,
    base5 = Base5,
    base0 = Base0,
    baseGradient = BaseGradient,
    primaryGradient = PrimaryGradient
)

private val DSDarkMaterialColors = darkColorScheme(
    primary = DSDarkImpl.primary1,
    secondary = DSDarkImpl.primary2,
    tertiary = DSDarkImpl.primary3,
    background = DSDarkImpl.base100,
    onBackground = DSDarkImpl.base80,
    onSecondary = DSDarkImpl.base60,
    onPrimaryContainer = DSDarkImpl.base40,
    surface = DSDarkImpl.base20
)

private val DSLightMaterialColors = lightColorScheme(
    primary = DSLightImpl.primary1,
    secondary = DSLightImpl.primary2,
    tertiary = DSLightImpl.primary3,
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
        secondary = primary2,
        tertiary = primary3,
        background = base100,
        onBackground = base80,
        onSecondary = base60,
        onPrimaryContainer = base40,
        surface = base20
    )
}
