package com.example.ui.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.ui.theme.PersianGold
import com.example.ui.theme.PersianGoldAmber
import com.example.ui.theme.PersianGoldLight

@Composable
fun TazhibDivider(
  modifier: Modifier = Modifier,
  goldColor: Color = PersianGold,
) {
  Canvas(
    modifier = modifier
      .fillMaxWidth()
      .height(28.dp)
      .padding(horizontal = 16.dp)
  ) {
    val w = size.width
    val h = size.height
    val midY = h / 2f
    val midX = w / 2f

    // Left line gradient
    drawLine(
      brush = Brush.horizontalGradient(
        colors = listOf(Color.Transparent, goldColor.copy(alpha = 0.8f)),
        startX = 0f,
        endX = midX - 28f
      ),
      start = Offset(0f, midY),
      end = Offset(midX - 28f, midY),
      strokeWidth = 1.8f
    )

    // Right line gradient
    drawLine(
      brush = Brush.horizontalGradient(
        colors = listOf(goldColor.copy(alpha = 0.8f), Color.Transparent),
        startX = midX + 28f,
        endX = w
      ),
      start = Offset(midX + 28f, midY),
      end = Offset(w, midY),
      strokeWidth = 1.8f
    )

    // Central Tazhib lozenge/diamond motif
    val diamondPath = Path().apply {
      moveTo(midX, midY - 10f)
      lineTo(midX + 10f, midY)
      lineTo(midX, midY + 10f)
      lineTo(midX - 10f, midY)
      close()
    }
    drawPath(diamondPath, color = goldColor)

    // Inner petal dots
    drawCircle(
      color = PersianGoldAmber,
      radius = 3.5f,
      center = Offset(midX, midY)
    )

    // Side pearls
    drawCircle(
      color = goldColor.copy(alpha = 0.9f),
      radius = 2.5f,
      center = Offset(midX - 18f, midY)
    )
    drawCircle(
      color = goldColor.copy(alpha = 0.9f),
      radius = 2.5f,
      center = Offset(midX + 18f, midY)
    )
  }
}

@Composable
fun GoldFrameCard(
  modifier: Modifier = Modifier,
  cornerRadius: Dp = 16.dp,
  backgroundColor: Color = MaterialTheme.colorScheme.surfaceVariant,
  borderColor: Color = PersianGold.copy(alpha = 0.5f),
  content: @Composable BoxScope.() -> Unit
) {
  val shape = RoundedCornerShape(cornerRadius)
  Box(
    modifier = modifier
      .clip(shape)
      .background(backgroundColor)
      .border(1.2.dp, borderColor, shape)
  ) {
    content()
  }
}

@Composable
fun SparkleParticleEffect(
  modifier: Modifier = Modifier,
  particleCount: Int = 12
) {
  val infiniteTransition = rememberInfiniteTransition(label = "sparkles")
  val pulse by infiniteTransition.animateFloat(
    initialValue = 0.3f,
    targetValue = 1f,
    animationSpec = infiniteRepeatable(
      animation = tween(1400, easing = FastOutSlowInEasing),
      repeatMode = RepeatMode.Reverse
    ),
    label = "pulse"
  )

  Canvas(modifier = modifier) {
    val w = size.width
    val h = size.height

    val randomPositions = listOf(
      Offset(w * 0.15f, h * 0.2f),
      Offset(w * 0.82f, h * 0.25f),
      Offset(w * 0.3f, h * 0.75f),
      Offset(w * 0.7f, h * 0.7f),
      Offset(w * 0.5f, h * 0.12f),
      Offset(w * 0.88f, h * 0.55f),
      Offset(w * 0.12f, h * 0.6f),
      Offset(w * 0.45f, h * 0.88f)
    )

    randomPositions.forEachIndexed { index, pos ->
      val factor = ((index % 3) + 1) * 0.33f
      val currentAlpha = (pulse * factor).coerceIn(0.2f, 1f)
      val starSize = 5f * pulse

      // 4-pointed golden sparkle star
      drawLine(
        color = PersianGoldLight.copy(alpha = currentAlpha),
        start = Offset(pos.x - starSize * 2, pos.y),
        end = Offset(pos.x + starSize * 2, pos.y),
        strokeWidth = 1.5f
      )
      drawLine(
        color = PersianGoldLight.copy(alpha = currentAlpha),
        start = Offset(pos.x, pos.y - starSize * 2),
        end = Offset(pos.x, pos.y + starSize * 2),
        strokeWidth = 1.5f
      )
      drawCircle(
        color = PersianGoldAmber.copy(alpha = currentAlpha),
        radius = 2.5f,
        center = pos
      )
    }
  }
}
