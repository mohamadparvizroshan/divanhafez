package com.example.ui.screens

import android.content.Context
import android.content.Intent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.DivanRepository
import com.example.model.AppLanguage
import com.example.model.Ghazal
import com.example.ui.components.GoldFrameCard
import com.example.ui.components.SparkleParticleEffect
import com.example.ui.components.TazhibDivider
import com.example.ui.theme.AmiriFontFamily
import com.example.ui.theme.PersianGold
import com.example.ui.theme.PersianGoldAmber
import com.example.ui.theme.PersianGoldDark
import com.example.ui.theme.PersianGoldLight
import com.example.ui.theme.PersianNightNavy
import com.example.ui.theme.PersianTurquoise
import com.example.ui.theme.PlayfairFontFamily
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun FaalScreen(
  repository: DivanRepository,
  currentLanguage: AppLanguage,
  isBookmarked: Boolean,
  onToggleBookmark: (Int) -> Unit,
  snackbarHostState: SnackbarHostState,
  modifier: Modifier = Modifier
) {
  val context = LocalContext.current
  val clipboardManager = LocalClipboardManager.current
  val coroutineScope = rememberCoroutineScope()

  var currentGhazal by remember { mutableStateOf<Ghazal?>(null) }
  var isConsulting by remember { mutableStateOf(false) }
  var showEnglishTranslation by remember { mutableStateOf(currentLanguage == AppLanguage.EN) }
  var showTransliteration by remember { mutableStateOf(false) }
  var isPlayingRecitation by remember { mutableStateOf(false) }

  // Rotation animation for divination
  val bookRotation = remember { Animatable(0f) }
  val bookScale = remember { Animatable(1f) }

  fun takeFaal() {
    coroutineScope.launch {
      isConsulting = true
      isPlayingRecitation = false

      // Elegant animation sequence
      bookScale.animateTo(0.92f, tween(300, easing = FastOutSlowInEasing))
      bookRotation.animateTo(12f, tween(400, easing = LinearEasing))
      bookRotation.animateTo(-8f, tween(300, easing = LinearEasing))
      bookRotation.animateTo(0f, tween(300, easing = FastOutSlowInEasing))
      bookScale.animateTo(1.05f, tween(350, easing = FastOutSlowInEasing))
      bookScale.animateTo(1f, tween(250, easing = FastOutSlowInEasing))

      delay(300)
      currentGhazal = repository.getRandomFaal()
      isConsulting = false
    }
  }

  fun shareGhazal(ghazal: Ghazal) {
    val shareText = buildString {
      append("📜 فال حافظ - غزل شماره ${ghazal.number}\n\n")
      append("${ghazal.verses.first().firstHalfFa} / ${ghazal.verses.first().secondHalfFa}\n\n")
      append("✨ تفسیر فال:\n${ghazal.interpretation.verdictFa}\n\n")
      append(ghazal.interpretation.messageFa)
      append("\n\n-- دیوان حافظ --")
    }
    val sendIntent = Intent().apply {
      action = Intent.ACTION_SEND
      putExtra(Intent.EXTRA_TEXT, shareText)
      type = "text/plain"
    }
    val shareIntent = Intent.createChooser(sendIntent, "اشتراک‌گذاری فال حافظ")
    context.startActivity(shareIntent)
  }

  LazyColumn(
    modifier = modifier
      .fillMaxSize()
      .testTag("faal_screen_content"),
    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
    verticalArrangement = Arrangement.spacedBy(16.dp)
  ) {
    // Top Hero Decorative Header
    item {
      GoldFrameCard(
        modifier = Modifier.fillMaxWidth(),
        cornerRadius = 20.dp
      ) {
        Box(modifier = Modifier.fillMaxWidth()) {
          Image(
            painter = painterResource(id = R.drawable.img_hafez_banner),
            contentDescription = "Persian Illumination Banner",
            modifier = Modifier
              .fillMaxWidth()
              .height(180.dp),
            contentScale = ContentScale.Crop
          )
          Box(
            modifier = Modifier
              .matchParentSize()
              .background(
                Brush.verticalGradient(
                  colors = listOf(
                    Color.Transparent,
                    PersianNightNavy.copy(alpha = 0.85f),
                    PersianNightNavy
                  )
                )
              )
          )

          Column(
            modifier = Modifier
              .align(Alignment.BottomCenter)
              .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
          ) {
            Text(
              text = if (currentLanguage == AppLanguage.FA) "فال دیوان خواجه حافظ شیرازی" else "Oracle of Divan-e Hafez",
              style = MaterialTheme.typography.headlineMedium.copy(
                fontFamily = if (currentLanguage == AppLanguage.FA) AmiriFontFamily else PlayfairFontFamily,
                color = PersianGoldLight,
                fontWeight = FontWeight.Bold
              ),
              textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
              text = if (currentLanguage == AppLanguage.FA)
                "ای حافظ شیرازی! تو کاشف هر رازی، بر ما بنما رازی..."
              else
                "O Hafez of Shiraz, unlocker of mysteries, reveal our destiny...",
              style = MaterialTheme.typography.bodyMedium.copy(
                color = PersianGoldAmber,
                fontFamily = if (currentLanguage == AppLanguage.FA) AmiriFontFamily else PlayfairFontFamily
              ),
              textAlign = TextAlign.Center
            )
          }
        }
      }
    }

    // Interactive Divination Invitation Card
    if (currentGhazal == null) {
      item {
        Card(
          modifier = Modifier
            .fillMaxWidth()
            .testTag("faal_invitation_card"),
          colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
          ),
          shape = RoundedCornerShape(20.dp),
          elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
          Box(modifier = Modifier.fillMaxWidth()) {
            SparkleParticleEffect(
              modifier = Modifier
                .matchParentSize()
                .padding(12.dp)
            )

            Column(
              modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
              horizontalAlignment = Alignment.CenterHorizontally
            ) {
              Box(
                modifier = Modifier
                  .size(110.dp)
                  .scale(bookScale.value)
                  .rotate(bookRotation.value)
                  .clip(CircleShape)
                  .border(2.5.dp, PersianGold, CircleShape)
                  .shadow(12.dp, CircleShape)
                  .clickable { takeFaal() },
                contentAlignment = Alignment.Center
              ) {
                Image(
                  painter = painterResource(id = R.drawable.ic_hafez_logo),
                  contentDescription = "Hafez Emblem",
                  modifier = Modifier.fillMaxSize(),
                  contentScale = ContentScale.Crop
                )
              }

              Spacer(modifier = Modifier.height(18.dp))

              Text(
                text = if (currentLanguage == AppLanguage.FA) "نیت کنید و دل بسپارید" else "Make Your Silent Intention",
                style = MaterialTheme.typography.titleLarge.copy(
                  color = PersianGold,
                  fontWeight = FontWeight.Bold
                ),
                textAlign = TextAlign.Center
              )

              Spacer(modifier = Modifier.height(8.dp))

              Text(
                text = if (currentLanguage == AppLanguage.FA)
                  "نیت خود را در دل مرور کنید، با خلوص نیت بر خواجه شیراز درود بفرستید و دکمه زیر را لمس نمایید تا دیوان گشوده شود."
                else
                  "Focus your mind on your question or prayer with sincerity, seek the poetic wisdom of Shiraz, and tap below to unveil your omen.",
                style = MaterialTheme.typography.bodyMedium.copy(
                  color = MaterialTheme.colorScheme.onSurfaceVariant
                ),
                textAlign = TextAlign.Center
              )

              Spacer(modifier = Modifier.height(20.dp))

              Button(
                onClick = { takeFaal() },
                modifier = Modifier
                  .fillMaxWidth(0.85f)
                  .height(54.dp)
                  .testTag("take_faal_button"),
                colors = ButtonDefaults.buttonColors(
                  containerColor = PersianGold,
                  contentColor = PersianNightNavy
                ),
                shape = RoundedCornerShape(28.dp),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 6.dp)
              ) {
                Icon(
                  imageVector = Icons.Default.AutoAwesome,
                  contentDescription = null,
                  modifier = Modifier.size(22.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                  text = if (isConsulting)
                    (if (currentLanguage == AppLanguage.FA) "در حال گشودن دیوان..." else "Opening the Divan...")
                  else
                    (if (currentLanguage == AppLanguage.FA) "گرفتن فال حافظ" else "Consult the Oracle (Take a Fal)"),
                  style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontFamily = if (currentLanguage == AppLanguage.FA) AmiriFontFamily else PlayfairFontFamily
                  )
                )
              }
            }
          }
        }
      }
    }

    // Revealed Ghazal & Full Interpretation
    currentGhazal?.let { ghazal ->
      item {
        AnimatedVisibility(
          visible = true,
          enter = fadeIn(tween(600)) + slideInVertically(tween(600))
        ) {
          Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {

            // Ghazal Top Bar Action Strip
            ElevatedCard(
              modifier = Modifier.fillMaxWidth(),
              colors = CardDefaults.elevatedCardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
              ),
              shape = RoundedCornerShape(16.dp)
            ) {
              Row(
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(horizontal = 14.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
              ) {
                Column {
                  Text(
                    text = if (currentLanguage == AppLanguage.FA)
                      "غزل شماره ${ghazal.number}"
                    else
                      "Ghazal #${ghazal.number}",
                    style = MaterialTheme.typography.titleMedium.copy(
                      color = PersianGold,
                      fontWeight = FontWeight.Bold
                    )
                  )
                  Text(
                    text = if (currentLanguage == AppLanguage.FA) ghazal.themeFa else ghazal.themeEn,
                    style = MaterialTheme.typography.labelSmall.copy(
                      color = PersianTurquoise
                    )
                  )
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                  // Audio recitation simulation toggle
                  IconButton(
                    onClick = {
                      isPlayingRecitation = !isPlayingRecitation
                      coroutineScope.launch {
                        snackbarHostState.showSnackbar(
                          if (isPlayingRecitation)
                            (if (currentLanguage == AppLanguage.FA) "در حال پخش زمزمه غزل..." else "Playing poem recitation chant...")
                          else
                            (if (currentLanguage == AppLanguage.FA) "پخش متوقف شد" else "Recitation stopped")
                        )
                      }
                    },
                    modifier = Modifier.testTag("recitation_audio_button")
                  ) {
                    Icon(
                      imageVector = if (isPlayingRecitation) Icons.Default.Stop else Icons.Default.PlayArrow,
                      contentDescription = "Audio Recitation",
                      tint = if (isPlayingRecitation) PersianTurquoise else PersianGold
                    )
                  }

                  // Bookmark
                  IconButton(
                    onClick = { onToggleBookmark(ghazal.id) },
                    modifier = Modifier.testTag("bookmark_faal_button")
                  ) {
                    Icon(
                      imageVector = if (isBookmarked) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                      contentDescription = "Bookmark",
                      tint = PersianGold
                    )
                  }

                  // Share
                  IconButton(
                    onClick = { shareGhazal(ghazal) },
                    modifier = Modifier.testTag("share_faal_button")
                  ) {
                    Icon(
                      imageVector = Icons.Default.Share,
                      contentDescription = "Share",
                      tint = PersianGold
                    )
                  }

                  // Copy
                  IconButton(
                    onClick = {
                      val poemText = "${ghazal.fullTextFa}\n\n${ghazal.interpretation.messageFa}"
                      clipboardManager.setText(AnnotatedString(poemText))
                      coroutineScope.launch {
                        snackbarHostState.showSnackbar(
                          if (currentLanguage == AppLanguage.FA) "متن غزل و فال کپی شد" else "Poem and omen copied"
                        )
                      }
                    },
                    modifier = Modifier.testTag("copy_faal_button")
                  ) {
                    Icon(
                      imageVector = Icons.Default.ContentCopy,
                      contentDescription = "Copy",
                      tint = PersianGold
                    )
                  }
                }
              }
            }

            // Audio Player Pulse Indicator if playing
            if (isPlayingRecitation) {
              Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = PersianTurquoise.copy(alpha = 0.15f)),
                shape = RoundedCornerShape(12.dp)
              ) {
                Row(
                  modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 10.dp),
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Text(
                    text = "🎵",
                    fontSize = 18.sp
                  )
                  Spacer(modifier = Modifier.width(10.dp))
                  Text(
                    text = if (currentLanguage == AppLanguage.FA)
                      "دکلمه آهنگین غزل با نوای سنتور و نی در جریان است..."
                    else
                      "Melodic recitation flowing with Persian Santoor & Ney...",
                    style = MaterialTheme.typography.bodySmall.copy(color = PersianTurquoise),
                    modifier = Modifier.weight(1f)
                  )
                }
              }
            }

            // View Mode Chips (Persian / Translation / Transliteration)
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
              FilterChip(
                selected = showEnglishTranslation,
                onClick = { showEnglishTranslation = !showEnglishTranslation },
                label = {
                  Text(if (currentLanguage == AppLanguage.FA) "ترجمه انگلیسی" else "English Translation")
                },
                leadingIcon = {
                  Icon(
                    imageVector = Icons.Default.Translate,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                  )
                },
                colors = FilterChipDefaults.filterChipColors(
                  selectedContainerColor = PersianGold.copy(alpha = 0.25f),
                  selectedLabelColor = PersianGoldLight
                )
              )

              FilterChip(
                selected = showTransliteration,
                onClick = { showTransliteration = !showTransliteration },
                label = {
                  Text(if (currentLanguage == AppLanguage.FA) "آوانگاری (تلفظ)" else "Transliteration")
                },
                colors = FilterChipDefaults.filterChipColors(
                  selectedContainerColor = PersianGold.copy(alpha = 0.25f),
                  selectedLabelColor = PersianGoldLight
                )
              )
            }

            // Ghazal Couplets Card
            GoldFrameCard(
              modifier = Modifier.fillMaxWidth(),
              cornerRadius = 18.dp,
              borderColor = PersianGold.copy(alpha = 0.7f)
            ) {
              Column(
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
              ) {
                Text(
                  text = ghazal.titleFa,
                  style = MaterialTheme.typography.displayMedium.copy(
                    fontFamily = AmiriFontFamily,
                    color = PersianGold,
                    fontWeight = FontWeight.Bold
                  ),
                  textAlign = TextAlign.Center
                )

                TazhibDivider(modifier = Modifier.padding(vertical = 12.dp))

                // Verses
                ghazal.verses.forEachIndexed { index, verse ->
                  Column(
                    modifier = Modifier
                      .fillMaxWidth()
                      .padding(vertical = 10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                  ) {
                    // First hemistich
                    Text(
                      text = verse.firstHalfFa,
                      style = MaterialTheme.typography.titleLarge.copy(
                        fontFamily = AmiriFontFamily,
                        fontSize = 20.sp,
                        lineHeight = 32.sp,
                        color = MaterialTheme.colorScheme.onSurface
                      ),
                      textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    // Second hemistich
                    Text(
                      text = verse.secondHalfFa,
                      style = MaterialTheme.typography.titleLarge.copy(
                        fontFamily = AmiriFontFamily,
                        fontSize = 20.sp,
                        lineHeight = 32.sp,
                        color = MaterialTheme.colorScheme.onSurface
                      ),
                      textAlign = TextAlign.Center
                    )

                    // Transliteration if enabled
                    if (showTransliteration) {
                      Spacer(modifier = Modifier.height(6.dp))
                      Text(
                        text = verse.transliteration,
                        style = MaterialTheme.typography.bodySmall.copy(
                          color = PersianGoldLight.copy(alpha = 0.8f),
                          fontFamily = PlayfairFontFamily
                        ),
                        textAlign = TextAlign.Center
                      )
                    }

                    // English Translation if enabled
                    if (showEnglishTranslation) {
                      Spacer(modifier = Modifier.height(6.dp))
                      Text(
                        text = verse.translationEn,
                        style = MaterialTheme.typography.bodyMedium.copy(
                          color = PersianTurquoise,
                          fontFamily = PlayfairFontFamily
                        ),
                        textAlign = TextAlign.Center
                      )
                    }

                    if (index < ghazal.verses.size - 1) {
                      Spacer(modifier = Modifier.height(8.dp))
                      Text(
                        text = "✦",
                        color = PersianGoldAmber.copy(alpha = 0.5f),
                        fontSize = 12.sp
                      )
                    }
                  }
                }
              }
            }

            // Comprehensive Interpretation Card ("تفسیر فال")
            ElevatedCard(
              modifier = Modifier
                .fillMaxWidth()
                .testTag("faal_interpretation_card"),
              colors = CardDefaults.elevatedCardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
              ),
              shape = RoundedCornerShape(18.dp),
              elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
            ) {
              Column(
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(20.dp)
              ) {
                Row(
                  verticalAlignment = Alignment.CenterVertically,
                  modifier = Modifier.fillMaxWidth()
                ) {
                  Icon(
                    imageVector = Icons.Default.FormatQuote,
                    contentDescription = null,
                    tint = PersianGold,
                    modifier = Modifier.size(28.dp)
                  )
                  Spacer(modifier = Modifier.width(8.dp))
                  Text(
                    text = if (currentLanguage == AppLanguage.FA) "تفسیر و تعبیر فال" else "Omen Interpretation & Meaning",
                    style = MaterialTheme.typography.titleLarge.copy(
                      color = PersianGold,
                      fontWeight = FontWeight.Bold
                    )
                  )
                }

                Spacer(modifier = Modifier.height(14.dp))

                // Verdict Box
                Surface(
                  shape = RoundedCornerShape(12.dp),
                  color = PersianTurquoise.copy(alpha = 0.16f),
                  border = androidx.compose.foundation.BorderStroke(1.dp, PersianTurquoise.copy(alpha = 0.4f)),
                  modifier = Modifier.fillMaxWidth()
                ) {
                  Row(
                    modifier = Modifier.padding(14.dp),
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Text(text = "✨", fontSize = 20.sp)
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                      text = if (currentLanguage == AppLanguage.FA)
                        ghazal.interpretation.verdictFa
                      else
                        ghazal.interpretation.verdictEn,
                      style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = PersianTurquoise
                      )
                    )
                  }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Spiritual Message
                Text(
                  text = if (currentLanguage == AppLanguage.FA) "پیام خواجه شیراز:" else "Message of the Mystic:",
                  style = MaterialTheme.typography.titleMedium.copy(
                    color = PersianGoldLight,
                    fontWeight = FontWeight.SemiBold
                  )
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                  text = if (currentLanguage == AppLanguage.FA)
                    ghazal.interpretation.messageFa
                  else
                    ghazal.interpretation.messageEn,
                  style = MaterialTheme.typography.bodyLarge.copy(
                    lineHeight = 26.sp
                  )
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Advice / Counsel
                Text(
                  text = if (currentLanguage == AppLanguage.FA) "پند و نصیحت فال:" else "Counsel for Action:",
                  style = MaterialTheme.typography.titleMedium.copy(
                    color = PersianGoldLight,
                    fontWeight = FontWeight.SemiBold
                  )
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                  text = if (currentLanguage == AppLanguage.FA)
                    ghazal.interpretation.adviceFa
                  else
                    ghazal.interpretation.adviceEn,
                  style = MaterialTheme.typography.bodyMedium.copy(
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    lineHeight = 24.sp
                  )
                )
              }
            }

            // Consult Again Button
            Button(
              onClick = { takeFaal() },
              modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .testTag("consult_again_button"),
              colors = ButtonDefaults.buttonColors(
                containerColor = PersianSurfaceDark,
                contentColor = PersianGold
              ),
              shape = RoundedCornerShape(14.dp),
              border = androidx.compose.foundation.BorderStroke(1.2.dp, PersianGold)
            ) {
              Icon(
                imageVector = Icons.Default.Refresh,
                contentDescription = null,
                modifier = Modifier.size(20.dp)
              )
              Spacer(modifier = Modifier.width(8.dp))
              Text(
                text = if (currentLanguage == AppLanguage.FA) "نیت دوباره و فال مجدد" else "Consult Again / Another Omen",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
              )
            }

            Spacer(modifier = Modifier.height(24.dp))
          }
        }
      }
    }
  }
}

private val PersianSurfaceDark = Color(0xFF132238)
