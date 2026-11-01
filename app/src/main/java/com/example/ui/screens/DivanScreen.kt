package com.example.ui.screens

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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.DivanRepository
import com.example.model.AppLanguage
import com.example.model.Ghazal
import com.example.ui.components.GoldFrameCard
import com.example.ui.theme.AmiriFontFamily
import com.example.ui.theme.PersianGold
import com.example.ui.theme.PersianGoldAmber
import com.example.ui.theme.PersianGoldDark
import com.example.ui.theme.PersianGoldLight
import com.example.ui.theme.PersianTurquoise
import com.example.ui.theme.PlayfairFontFamily

@Composable
fun DivanScreen(
  repository: DivanRepository,
  currentLanguage: AppLanguage,
  bookmarkedIds: Set<Int>,
  onToggleBookmark: (Int) -> Unit,
  onSelectGhazal: (Ghazal) -> Unit,
  modifier: Modifier = Modifier
) {
  var searchQuery by remember { mutableStateOf("") }
  var selectedFilter by remember { mutableStateOf(0) } // 0: All, 1: Love/عشق, 2: Hope/امید, 3: Wisdom/حکمت

  val allGhazals = remember { repository.getAllGhazals() }
  val dailyGhazal = remember { repository.getDailyGhazal() }

  val filteredGhazals = remember(searchQuery, selectedFilter) {
    var result = repository.searchGhazals(searchQuery)
    if (selectedFilter == 1) {
      result = result.filter { it.themeFa.contains("عشق") || it.themeEn.contains("Love") }
    } else if (selectedFilter == 2) {
      result = result.filter { it.themeFa.contains("امید") || it.themeEn.contains("Hope") }
    } else if (selectedFilter == 3) {
      result = result.filter { it.themeFa.contains("حکمت") || it.themeEn.contains("Wisdom") || it.themeFa.contains("معرفت") }
    }
    result
  }

  val filterOptions = listOf(
    if (currentLanguage == AppLanguage.FA) "همه غزل‌ها" else "All Ghazals",
    if (currentLanguage == AppLanguage.FA) "عشق و معرفت" else "Love & Gnosis",
    if (currentLanguage == AppLanguage.FA) "امید و گشایش" else "Hope & Solace",
    if (currentLanguage == AppLanguage.FA) "پند و حکمت" else "Wisdom & Life"
  )

  LazyColumn(
    modifier = modifier
      .fillMaxSize()
      .testTag("divan_screen_content"),
    contentPadding = PaddingValues(16.dp),
    verticalArrangement = Arrangement.spacedBy(14.dp)
  ) {
    // Search Bar
    item {
      OutlinedTextField(
        value = searchQuery,
        onValueChange = { searchQuery = it },
        modifier = Modifier
          .fillMaxWidth()
          .testTag("ghazal_search_input"),
        placeholder = {
          Text(
            if (currentLanguage == AppLanguage.FA)
              "جستجو در ابیات، مطلع، یا شماره غزل..."
            else
              "Search verses, opening line, or number..."
          )
        },
        leadingIcon = {
          Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Search",
            tint = PersianGold
          )
        },
        trailingIcon = {
          if (searchQuery.isNotEmpty()) {
            IconButton(onClick = { searchQuery = "" }) {
              Icon(
                imageVector = Icons.Default.Clear,
                contentDescription = "Clear",
                tint = PersianGold
              )
            }
          }
        },
        singleLine = true,
        shape = RoundedCornerShape(16.dp),
        colors = OutlinedTextFieldDefaults.colors(
          focusedBorderColor = PersianGold,
          unfocusedBorderColor = PersianGold.copy(alpha = 0.5f),
          focusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
          unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant
        )
      )
    }

    // Filter Chips
    item {
      LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
      ) {
        items(filterOptions.size) { index ->
          FilterChip(
            selected = selectedFilter == index,
            onClick = { selectedFilter = index },
            label = { Text(filterOptions[index]) },
            colors = FilterChipDefaults.filterChipColors(
              selectedContainerColor = PersianGold.copy(alpha = 0.25f),
              selectedLabelColor = PersianGoldLight,
              containerColor = MaterialTheme.colorScheme.surfaceVariant
            )
          )
        }
      }
    }

    // Daily Ghazal Spotlight if not searching
    if (searchQuery.isEmpty() && selectedFilter == 0) {
      item {
        GoldFrameCard(
          modifier = Modifier
            .fillMaxWidth()
            .clickable { onSelectGhazal(dailyGhazal) }
            .testTag("daily_ghazal_spotlight"),
          borderColor = PersianGoldAmber,
          cornerRadius = 16.dp
        ) {
          Column(modifier = Modifier.padding(16.dp)) {
            Row(
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.SpaceBetween,
              modifier = Modifier.fillMaxWidth()
            ) {
              Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                  imageVector = Icons.Default.AutoAwesome,
                  contentDescription = null,
                  tint = PersianGoldAmber,
                  modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                  text = if (currentLanguage == AppLanguage.FA) "غزل روز" else "Ghazal of the Day",
                  style = MaterialTheme.typography.labelLarge.copy(
                    color = PersianGoldAmber,
                    fontWeight = FontWeight.Bold
                  )
                )
              }
              Text(
                text = if (currentLanguage == AppLanguage.FA) "شماره ${dailyGhazal.number}" else "#${dailyGhazal.number}",
                style = MaterialTheme.typography.labelMedium.copy(color = PersianGoldLight)
              )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
              text = dailyGhazal.verses.first().firstHalfFa,
              style = MaterialTheme.typography.titleMedium.copy(
                fontFamily = AmiriFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp,
                color = MaterialTheme.colorScheme.onSurface
              )
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
              text = dailyGhazal.verses.first().secondHalfFa,
              style = MaterialTheme.typography.titleMedium.copy(
                fontFamily = AmiriFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp,
                color = MaterialTheme.colorScheme.onSurface
              )
            )

            if (currentLanguage == AppLanguage.EN) {
              Spacer(modifier = Modifier.height(6.dp))
              Text(
                text = dailyGhazal.verses.first().translationEn,
                style = MaterialTheme.typography.bodySmall.copy(
                  fontFamily = PlayfairFontFamily,
                  color = PersianTurquoise
                )
              )
            }
          }
        }
      }
    }

    // Results Header Count
    item {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Text(
          text = if (currentLanguage == AppLanguage.FA)
            "فهرست غزل‌ها (${filteredGhazals.size})"
          else
            "Ghazals List (${filteredGhazals.size})",
          style = MaterialTheme.typography.titleMedium.copy(
            color = PersianGold,
            fontWeight = FontWeight.Bold
          )
        )
      }
    }

    // Ghazal Items List
    items(filteredGhazals, key = { it.id }) { ghazal ->
      val isFav = bookmarkedIds.contains(ghazal.id)
      GhazalListItem(
        ghazal = ghazal,
        currentLanguage = currentLanguage,
        isBookmarked = isFav,
        onToggleBookmark = { onToggleBookmark(ghazal.id) },
        onClick = { onSelectGhazal(ghazal) }
      )
    }

    item {
      Spacer(modifier = Modifier.height(16.dp))
    }
  }
}

@Composable
fun GhazalListItem(
  ghazal: Ghazal,
  currentLanguage: AppLanguage,
  isBookmarked: Boolean,
  onToggleBookmark: () -> Unit,
  onClick: () -> Unit
) {
  Card(
    modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(14.dp))
      .clickable { onClick() }
      .testTag("ghazal_item_${ghazal.id}"),
    colors = CardDefaults.cardColors(
      containerColor = MaterialTheme.colorScheme.surfaceVariant
    ),
    shape = RoundedCornerShape(14.dp),
    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(14.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      // Number Badge in Golden Ring
      Box(
        modifier = Modifier
          .size(46.dp)
          .clip(CircleShape)
          .border(1.5.dp, PersianGold, CircleShape)
          .background(PersianGold.copy(alpha = 0.1f)),
        contentAlignment = Alignment.Center
      ) {
        Text(
          text = "${ghazal.number}",
          style = MaterialTheme.typography.titleMedium.copy(
            color = PersianGoldLight,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp
          )
        )
      }

      Spacer(modifier = Modifier.width(14.dp))

      // Verses preview & Theme
      Column(modifier = Modifier.weight(1f)) {
        Text(
          text = if (currentLanguage == AppLanguage.FA) ghazal.titleFa else ghazal.titleEn,
          style = MaterialTheme.typography.titleMedium.copy(
            fontFamily = if (currentLanguage == AppLanguage.FA) AmiriFontFamily else PlayfairFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.onSurface
          ),
          maxLines = 1,
          overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.height(3.dp))

        Text(
          text = "${ghazal.verses.first().firstHalfFa}...",
          style = MaterialTheme.typography.bodyMedium.copy(
            fontFamily = AmiriFontFamily,
            fontSize = 15.sp,
            color = PersianGoldLight.copy(alpha = 0.85f)
          ),
          maxLines = 1,
          overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
          text = if (currentLanguage == AppLanguage.FA) ghazal.themeFa else ghazal.themeEn,
          style = MaterialTheme.typography.labelSmall.copy(
            color = PersianTurquoise
          )
        )
      }

      // Bookmark Button
      IconButton(onClick = onToggleBookmark) {
        Icon(
          imageVector = if (isBookmarked) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
          contentDescription = "Bookmark",
          tint = if (isBookmarked) PersianGold else MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f)
        )
      }
    }
  }
}
