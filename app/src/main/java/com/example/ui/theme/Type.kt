package com.example.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.R

val VazirmatnFontFamily = FontFamily(
  Font(R.font.vazirmatn, FontWeight.Normal),
  Font(R.font.vazirmatn, FontWeight.Medium),
  Font(R.font.vazirmatn, FontWeight.Bold)
)

val AmiriFontFamily = FontFamily(
  Font(R.font.amiri, FontWeight.Normal),
  Font(R.font.amiri, FontWeight.Bold)
)

val PlayfairFontFamily = FontFamily(
  Font(R.font.playfair_display, FontWeight.Normal),
  Font(R.font.playfair_display, FontWeight.Bold)
)

val HafezTypography = Typography(
  displayLarge = TextStyle(
    fontFamily = AmiriFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 32.sp,
    lineHeight = 44.sp,
    letterSpacing = 0.sp
  ),
  displayMedium = TextStyle(
    fontFamily = AmiriFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 26.sp,
    lineHeight = 36.sp,
    letterSpacing = 0.sp
  ),
  headlineLarge = TextStyle(
    fontFamily = VazirmatnFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 22.sp,
    lineHeight = 32.sp
  ),
  headlineMedium = TextStyle(
    fontFamily = VazirmatnFontFamily,
    fontWeight = FontWeight.SemiBold,
    fontSize = 20.sp,
    lineHeight = 28.sp
  ),
  titleLarge = TextStyle(
    fontFamily = VazirmatnFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 18.sp,
    lineHeight = 26.sp
  ),
  titleMedium = TextStyle(
    fontFamily = VazirmatnFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 16.sp,
    lineHeight = 24.sp
  ),
  bodyLarge = TextStyle(
    fontFamily = VazirmatnFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
    lineHeight = 26.sp
  ),
  bodyMedium = TextStyle(
    fontFamily = VazirmatnFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp,
    lineHeight = 22.sp
  ),
  labelLarge = TextStyle(
    fontFamily = VazirmatnFontFamily,
    fontWeight = FontWeight.SemiBold,
    fontSize = 14.sp,
    lineHeight = 20.sp
  ),
  labelMedium = TextStyle(
    fontFamily = VazirmatnFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 12.sp,
    lineHeight = 16.sp
  )
)
