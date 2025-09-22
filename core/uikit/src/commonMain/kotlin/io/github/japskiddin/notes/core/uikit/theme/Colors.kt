package io.github.japskiddin.notes.core.uikit.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

public val Thunder: Color = Color(0xFF2E2E2E)
public val GreenishBlue: Color = Color(0xFF246F8A)
public val GreenWhite: Color = Color(0xFFE8E8E8)
public val BlackCow: Color = Color(0xFF454545)

internal val LightColorScheme = lightColorScheme(
    primary = GreenishBlue,
    onPrimary = Color.White,
    background = Color.White,
    surface = Color.White,
    onSurface = Color.Black,
    surfaceContainer = GreenWhite,
)

internal val DarkColorScheme = darkColorScheme(
    primary = GreenishBlue,
    onPrimary = Color.White,
    background = Thunder,
    surface = Thunder,
    onSurface = Color.White,
    surfaceContainer = BlackCow,
)
