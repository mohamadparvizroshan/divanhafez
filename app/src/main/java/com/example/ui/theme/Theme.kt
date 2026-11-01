package com.example.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val PersianDarkColorScheme = darkColorScheme(
  primary = PersianGold,
  onPrimary = PersianNightNavy,
  primaryContainer = PersianSurfaceCard,
  onPrimaryContainer = PersianGoldLight,
  secondary = PersianTurquoise,
  onSecondary = Color.White,
  secondaryContainer = PersianLapis,
  onSecondaryContainer = Color.White,
  tertiary = PersianGoldLight,
  onTertiary = PersianNightNavy,
  background = PersianNightNavy,
  onBackground = Color(0xFFF0F4F8),
  surface = PersianDeepNavy,
  onSurface = Color(0xFFF0F4F8),
  surfaceVariant = PersianSurfaceDark,
  onSurfaceVariant = Color(0xFFCAD5E2),
  outline = PersianGoldDark,
  outlineVariant = GoldBorder
)

private val PersianLightColorScheme = lightColorScheme(
  primary = PersianGoldDark,
  onPrimary = Color.White,
  primaryContainer = ParchmentCard,
  onPrimaryContainer = InkPrimary,
  secondary = PersianTurquoise,
  onSecondary = Color.White,
  secondaryContainer = Color(0xFFE2F3F2),
  onSecondaryContainer = Color(0xFF003736),
  tertiary = PersianLapis,
  onTertiary = Color.White,
  background = ParchmentBg,
  onBackground = InkPrimary,
  surface = ParchmentSurface,
  onSurface = InkPrimary,
  surfaceVariant = ParchmentCard,
  onSurfaceVariant = InkSecondary,
  outline = PersianGold,
  outlineVariant = Color(0x33B8860B)
)

@Composable
fun HafezTheme(
  darkTheme: Boolean = true, // Default to stunning Persian midnight luxury theme
  content: @Composable () -> Unit,
) {
  val colorScheme = if (darkTheme) PersianDarkColorScheme else PersianLightColorScheme

  MaterialTheme(
    colorScheme = colorScheme,
    typography = HafezTypography,
    content = content
  )
}
