package com.example.ui.screens

import android.content.Context
import android.content.Intent
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material.icons.filled.TextFields
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.AppLanguage
import com.example.model.Ghazal
import com.example.ui.components.GoldFrameCard
import com.example.ui.components.TazhibDivider
import com.example.ui.theme.AmiriFontFamily
import com.example.ui.theme.PersianGold
import com.example.ui.theme.PersianGoldAmber
import com.example.ui.theme.PersianGoldLight
import com.example.ui.theme.PersianTurquoise
import com.example.ui.theme.PlayfairFontFamily
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GhazalDetailScreen(
  ghazal: Ghazal,
  currentLanguage: AppLanguage,
  isBookmarked: Boolean,
  onToggleBookmark: () -> Unit,
  onBack: () -> Unit,
  modifier: Modifier = Modifier
) {
  BackHandler { onBack() }

  val context = LocalContext.current
  val clipboardManager = LocalClipboardManager.current
  val snackbarHostState = remember { SnackbarHostState() }
  val coroutineScope = rememberCoroutineScope()

  var fontSizeSp by remember { mutableFloatStateOf(20f) }
  var showTranslation by remember { mutableStateOf(currentLanguage == AppLanguage.EN) }
  var showTransliteration by remember { mutableStateOf(false) }
  var isPlayingAudio by remember { mutableStateOf(false) }

  fun sharePoem() {
    val text = buildString {
      append("📜 دیوان حافظ - غزل شماره ${ghazal.number}\n\n")
      append(ghazal.fullTextFa)
      append("\n\n-- دیوان حافظ --")
    }
    val sendIntent = Intent().apply {
      action = Intent.ACTION_SEND
      putExtra(Intent.EXTRA_TEXT, text)
      type = "text/plain"
    }
    context.startActivity(Intent.createChooser(sendIntent, "اشتراک غزل حافظ"))
  }

  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Text(
            text = if (currentLanguage == AppLanguage.FA)
              "غزل شماره ${ghazal.number}"
            else
              "Ghazal #${ghazal.number}",
            style = MaterialTheme.typography.titleLarge.copy(
              color = PersianGold,
              fontWeight = FontWeight.Bold
            )
          )
        },
        navigationIcon = {
          IconButton(onClick = onBack, modifier = Modifier.testTag("detail_back_button")) {
            Icon(
              imageVector = Icons.AutoMirrored.Filled.ArrowBack,
              contentDescription = "Back",
              tint = PersianGold
            )
          }
        },
        actions = {
          IconButton(onClick = {
            isPlayingAudio = !isPlayingAudio
            coroutineScope.launch {
              snackbarHostState.showSnackbar(
                if (isPlayingAudio)
                  (if (currentLanguage == AppLanguage.FA) "پخش زمزمه غزل آغاز شد" else "Poem recitation started")
                else
                  (if (currentLanguage == AppLanguage.FA) "پخش متوقف شد" else "Recitation paused")
              )
            }
          }) {
            Icon(
              imageVector = if (isPlayingAudio) Icons.Default.Stop else Icons.Default.PlayArrow,
              contentDescription = "Play",
              tint = if (isPlayingAudio) PersianTurquoise else PersianGold
            )
          }

          IconButton(onClick = onToggleBookmark) {
            Icon(
              imageVector = if (isBookmarked) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
              contentDescription = "Bookmark",
              tint = PersianGold
            )
          }

          IconButton(onClick = { sharePoem() }) {
            Icon(
              imageVector = Icons.Default.Share,
              contentDescription = "Share",
              tint = PersianGold
            )
          }

          IconButton(onClick = {
            clipboardManager.setText(AnnotatedString(ghazal.fullTextFa))
            coroutineScope.launch {
              snackbarHostState.showSnackbar(
                if (currentLanguage == AppLanguage.FA) "متن ابیات کپی شد" else "Verses copied to clipboard"
              )
            }
          }) {
            Icon(
              imageVector = Icons.Default.ContentCopy,
              contentDescription = "Copy",
              tint = PersianGold
            )
          }
        },
        colors = TopAppBarDefaults.topAppBarColors(
          containerColor = MaterialTheme.colorScheme.surface
        )
      )
    },
    snackbarHost = { SnackbarHost(snackbarHostState) },
    modifier = modifier.fillMaxSize()
  ) { innerPadding ->
    LazyColumn(
      modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding)
        .testTag("ghazal_detail_content"),
      contentPadding = PaddingValues(16.dp),
      verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
      // Audio Recitation Note if playing
      if (isPlayingAudio) {
        item {
          Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = PersianTurquoise.copy(alpha = 0.15f)),
            shape = RoundedCornerShape(12.dp)
          ) {
            Row(
              modifier = Modifier.padding(14.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(text = "🎶", fontSize = 18.sp)
              Spacer(modifier = Modifier.width(10.dp))
              Text(
                text = if (currentLanguage == AppLanguage.FA)
                  "نوای ساز و زمزمه عرفانی غزل در حال پخش است..."
                else
                  "Mystic sound and melody flowing...",
                style = MaterialTheme.typography.bodySmall.copy(color = PersianTurquoise)
              )
            }
          }
        }
      }

      // Display Control Chips (Font size +/- and Translations)
      item {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(
              selected = showTranslation,
              onClick = { showTranslation = !showTranslation },
              label = { Text(if (currentLanguage == AppLanguage.FA) "ترجمه" else "Translation") },
              leadingIcon = {
                Icon(
                  imageVector = Icons.Default.Translate,
                  contentDescription = null,
                  modifier = Modifier.size(14.dp)
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
              label = { Text(if (currentLanguage == AppLanguage.FA) "آوانگاری" else "Phonetics") },
              colors = FilterChipDefaults.filterChipColors(
                selectedContainerColor = PersianGold.copy(alpha = 0.25f),
                selectedLabelColor = PersianGoldLight
              )
            )
          }

          // Font Resizing controls
          Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
              imageVector = Icons.Default.TextFields,
              contentDescription = null,
              tint = PersianGold,
              modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            IconButton(
              onClick = { if (fontSizeSp > 16f) fontSizeSp -= 2f },
              modifier = Modifier.size(34.dp)
            ) {
              Text("A-", color = PersianGold, fontWeight = FontWeight.Bold, fontSize = 12.sp)
            }
            IconButton(
              onClick = { if (fontSizeSp < 28f) fontSizeSp += 2f },
              modifier = Modifier.size(34.dp)
            ) {
              Text("A+", color = PersianGold, fontWeight = FontWeight.Bold, fontSize = 14.sp)
            }
          }
        }
      }

      // Couplets Presentation Card
      item {
        GoldFrameCard(
          modifier = Modifier.fillMaxWidth(),
          cornerRadius = 20.dp,
          borderColor = PersianGold.copy(alpha = 0.8f)
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

            if (currentLanguage == AppLanguage.EN) {
              Spacer(modifier = Modifier.height(4.dp))
              Text(
                text = ghazal.titleEn,
                style = MaterialTheme.typography.titleMedium.copy(
                  fontFamily = PlayfairFontFamily,
                  color = PersianTurquoise
                ),
                textAlign = TextAlign.Center
              )
            }

            TazhibDivider(modifier = Modifier.padding(vertical = 12.dp))

            ghazal.verses.forEachIndexed { index, verse ->
              Column(
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(vertical = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
              ) {
                // Hemistich 1
                Text(
                  text = verse.firstHalfFa,
                  style = MaterialTheme.typography.titleLarge.copy(
                    fontFamily = AmiriFontFamily,
                    fontSize = fontSizeSp.sp,
                    lineHeight = (fontSizeSp * 1.6f).sp,
                    color = MaterialTheme.colorScheme.onSurface
                  ),
                  textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(4.dp))
                // Hemistich 2
                Text(
                  text = verse.secondHalfFa,
                  style = MaterialTheme.typography.titleLarge.copy(
                    fontFamily = AmiriFontFamily,
                    fontSize = fontSizeSp.sp,
                    lineHeight = (fontSizeSp * 1.6f).sp,
                    color = MaterialTheme.colorScheme.onSurface
                  ),
                  textAlign = TextAlign.Center
                )

                if (showTransliteration) {
                  Spacer(modifier = Modifier.height(6.dp))
                  Text(
                    text = verse.transliteration,
                    style = MaterialTheme.typography.bodySmall.copy(
                      fontFamily = PlayfairFontFamily,
                      color = PersianGoldLight.copy(alpha = 0.8f)
                    ),
                    textAlign = TextAlign.Center
                  )
                }

                if (showTranslation) {
                  Spacer(modifier = Modifier.height(6.dp))
                  Text(
                    text = verse.translationEn,
                    style = MaterialTheme.typography.bodyMedium.copy(
                      fontFamily = PlayfairFontFamily,
                      color = PersianTurquoise
                    ),
                    textAlign = TextAlign.Center
                  )
                }

                if (index < ghazal.verses.size - 1) {
                  Spacer(modifier = Modifier.height(10.dp))
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
      }

      // Mystic Interpretation & Meaning
      item {
        Card(
          modifier = Modifier.fillMaxWidth(),
          colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
          shape = RoundedCornerShape(16.dp)
        ) {
          Column(modifier = Modifier.padding(18.dp)) {
            Text(
              text = if (currentLanguage == AppLanguage.FA) "تفسیر و مفهوم عرفانی غزل" else "Mystical Insight & Commentary",
              style = MaterialTheme.typography.titleMedium.copy(
                color = PersianGold,
                fontWeight = FontWeight.Bold
              )
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
              text = if (currentLanguage == AppLanguage.FA)
                ghazal.interpretation.messageFa
              else
                ghazal.interpretation.messageEn,
              style = MaterialTheme.typography.bodyMedium.copy(
                lineHeight = 24.sp,
                color = MaterialTheme.colorScheme.onSurface
              )
            )

            Spacer(modifier = Modifier.height(12.dp))

            Surface(
              shape = RoundedCornerShape(10.dp),
              color = PersianTurquoise.copy(alpha = 0.12f),
              modifier = Modifier.fillMaxWidth()
            ) {
              Text(
                text = if (currentLanguage == AppLanguage.FA)
                  "پند خواجه: ${ghazal.interpretation.adviceFa}"
                else
                  "Wisdom: ${ghazal.interpretation.adviceEn}",
                style = MaterialTheme.typography.bodySmall.copy(
                  color = PersianTurquoise,
                  fontWeight = FontWeight.Medium
                ),
                modifier = Modifier.padding(12.dp)
              )
            }
          }
        }
      }

      item {
        Spacer(modifier = Modifier.height(20.dp))
      }
    }
  }
}
