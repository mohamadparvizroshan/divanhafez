package com.example.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.DivanRepository
import com.example.model.AppLanguage
import com.example.model.Ghazal
import com.example.ui.theme.PersianGold
import com.example.ui.theme.PersianNightNavy

@Composable
fun BookmarksScreen(
  repository: DivanRepository,
  currentLanguage: AppLanguage,
  bookmarkedIds: Set<Int>,
  onToggleBookmark: (Int) -> Unit,
  onSelectGhazal: (Ghazal) -> Unit,
  onNavigateToDivan: () -> Unit,
  modifier: Modifier = Modifier
) {
  val bookmarkedGhazals = repository.getAllGhazals().filter { bookmarkedIds.contains(it.id) }

  if (bookmarkedGhazals.isEmpty()) {
    Box(
      modifier = modifier
        .fillMaxSize()
        .padding(24.dp)
        .testTag("bookmarks_empty_state"),
      contentAlignment = Alignment.Center
    ) {
      Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
      ) {
        Icon(
          imageVector = Icons.Default.BookmarkBorder,
          contentDescription = null,
          tint = PersianGold.copy(alpha = 0.6f),
          modifier = Modifier.size(64.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
          text = if (currentLanguage == AppLanguage.FA)
            "هنوز غزلی را نشان نکرده‌اید"
          else
            "No Bookmarked Ghazals Yet",
          style = MaterialTheme.typography.titleLarge.copy(
            color = PersianGold,
            fontWeight = FontWeight.Bold
          ),
          textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
          text = if (currentLanguage == AppLanguage.FA)
            "در بخش فال یا دیوان اشعار، با لمس آیکون نشان، غزل‌های محبوب خود را اینجا ذخیره کنید."
          else
            "While exploring the Divan or taking a Fal, tap the bookmark icon to save your favorite verses here.",
          style = MaterialTheme.typography.bodyMedium.copy(
            color = MaterialTheme.colorScheme.onSurfaceVariant
          ),
          textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
          onClick = onNavigateToDivan,
          colors = ButtonDefaults.buttonColors(
            containerColor = PersianGold,
            contentColor = PersianNightNavy
          ),
          shape = RoundedCornerShape(20.dp)
        ) {
          Text(
            text = if (currentLanguage == AppLanguage.FA) "مرور دیوان اشعار" else "Explore the Divan",
            fontWeight = FontWeight.Bold
          )
        }
      }
    }
  } else {
    LazyColumn(
      modifier = modifier
        .fillMaxSize()
        .testTag("bookmarks_list"),
      contentPadding = PaddingValues(16.dp),
      verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
      item {
        Text(
          text = if (currentLanguage == AppLanguage.FA)
            "غزل‌های برگزیده و نشان‌شده (${bookmarkedGhazals.size})"
          else
            "Saved Ghazals (${bookmarkedGhazals.size})",
          style = MaterialTheme.typography.titleMedium.copy(
            color = PersianGold,
            fontWeight = FontWeight.Bold
          ),
          modifier = Modifier.padding(horizontal = 4.dp, vertical = 6.dp)
        )
      }

      items(bookmarkedGhazals, key = { it.id }) { ghazal ->
        GhazalListItem(
          ghazal = ghazal,
          currentLanguage = currentLanguage,
          isBookmarked = true,
          onToggleBookmark = { onToggleBookmark(ghazal.id) },
          onClick = { onSelectGhazal(ghazal) }
        )
      }
    }
  }
}
