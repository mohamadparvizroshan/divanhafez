package com.example.ui

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material.icons.outlined.AutoAwesome
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.MenuBook
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.DivanRepository
import com.example.model.AppLanguage
import com.example.model.Ghazal
import com.example.model.MainTab
import com.example.ui.screens.AboutScreen
import com.example.ui.screens.BookmarksScreen
import com.example.ui.screens.DivanScreen
import com.example.ui.screens.FaalScreen
import com.example.ui.screens.GhazalDetailScreen
import com.example.ui.theme.AmiriFontFamily
import com.example.ui.theme.PersianGold
import com.example.ui.theme.PersianGoldLight
import com.example.ui.theme.PersianNightNavy
import com.example.ui.theme.PersianTurquoise
import com.example.ui.theme.PlayfairFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HafezMainScreen(
  repository: DivanRepository,
  isDarkTheme: Boolean,
  onToggleDarkTheme: () -> Unit,
  modifier: Modifier = Modifier
) {
  var currentLanguage by remember { mutableStateOf(AppLanguage.FA) }
  var currentTab by remember { mutableStateOf(MainTab.FAAL) }
  var selectedGhazalForDetail by remember { mutableStateOf<Ghazal?>(null) }
  val snackbarHostState = remember { SnackbarHostState() }

  val bookmarkedIds by repository.bookmarkedIds.collectAsState()

  val layoutDirection = if (currentLanguage == AppLanguage.FA) LayoutDirection.Rtl else LayoutDirection.Ltr

  CompositionLocalProvider(LocalLayoutDirection provides layoutDirection) {
    if (selectedGhazalForDetail != null) {
      val ghazal = selectedGhazalForDetail!!
      GhazalDetailScreen(
        ghazal = ghazal,
        currentLanguage = currentLanguage,
        isBookmarked = bookmarkedIds.contains(ghazal.id),
        onToggleBookmark = { repository.toggleBookmark(ghazal.id) },
        onBack = { selectedGhazalForDetail = null }
      )
    } else {
      Scaffold(
        topBar = {
          CenterAlignedTopAppBar(
            title = {
              Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.testTag("app_header_title")
              ) {
                Box(
                  modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
                    .border(1.2.dp, PersianGold, CircleShape)
                ) {
                  Image(
                    painter = painterResource(id = R.drawable.ic_hafez_logo),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                  )
                }

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                  text = if (currentLanguage == AppLanguage.FA) "دیوان حافظ" else "Divan-e Hafez",
                  style = MaterialTheme.typography.titleLarge.copy(
                    fontFamily = if (currentLanguage == AppLanguage.FA) AmiriFontFamily else PlayfairFontFamily,
                    color = PersianGold,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                  )
                )
              }
            },
            navigationIcon = {
              // Language Switcher
              Surface(
                onClick = {
                  currentLanguage = if (currentLanguage == AppLanguage.FA) AppLanguage.EN else AppLanguage.FA
                },
                shape = RoundedCornerShape(16.dp),
                color = MaterialTheme.colorScheme.surfaceVariant,
                border = androidx.compose.foundation.BorderStroke(1.dp, PersianGold.copy(alpha = 0.5f)),
                modifier = Modifier
                  .padding(start = 12.dp)
                  .testTag("language_toggle_button")
              ) {
                Row(
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp),
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Icon(
                    imageVector = Icons.Default.Translate,
                    contentDescription = "Language",
                    tint = PersianGold,
                    modifier = Modifier.size(16.dp)
                  )
                  Spacer(modifier = Modifier.width(4.dp))
                  Text(
                    text = if (currentLanguage == AppLanguage.FA) "EN" else "فا",
                    style = MaterialTheme.typography.labelMedium.copy(
                      fontWeight = FontWeight.Bold,
                      color = PersianGoldLight
                    )
                  )
                }
              }
            },
            actions = {
              // Dark / Light Theme Toggle
              IconButton(
                onClick = onToggleDarkTheme,
                modifier = Modifier.testTag("theme_toggle_button")
              ) {
                Icon(
                  imageVector = if (isDarkTheme) Icons.Default.LightMode else Icons.Default.DarkMode,
                  contentDescription = "Toggle Theme",
                  tint = PersianGold
                )
              }
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
              containerColor = MaterialTheme.colorScheme.surface
            )
          )
        },
        bottomBar = {
          NavigationBar(
            containerColor = MaterialTheme.colorScheme.surface,
            tonalElevation = 8.dp,
            modifier = Modifier.windowInsetsPadding(WindowInsets.navigationBars)
          ) {
            // Faal Tab
            NavigationBarItem(
              selected = currentTab == MainTab.FAAL,
              onClick = { currentTab = MainTab.FAAL },
              icon = {
                Icon(
                  imageVector = if (currentTab == MainTab.FAAL) Icons.Default.AutoAwesome else Icons.Outlined.AutoAwesome,
                  contentDescription = MainTab.FAAL.faTitle
                )
              },
              label = {
                Text(
                  text = if (currentLanguage == AppLanguage.FA) MainTab.FAAL.faTitle else MainTab.FAAL.enTitle,
                  maxLines = 1
                )
              },
              colors = NavigationBarItemDefaults.colors(
                selectedIconColor = PersianNightNavy,
                selectedTextColor = PersianGold,
                indicatorColor = PersianGold,
                unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f),
                unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
              ),
              modifier = Modifier.testTag("nav_item_faal")
            )

            // Divan Tab
            NavigationBarItem(
              selected = currentTab == MainTab.DIVAN,
              onClick = { currentTab = MainTab.DIVAN },
              icon = {
                Icon(
                  imageVector = if (currentTab == MainTab.DIVAN) Icons.Default.MenuBook else Icons.Outlined.MenuBook,
                  contentDescription = MainTab.DIVAN.faTitle
                )
              },
              label = {
                Text(
                  text = if (currentLanguage == AppLanguage.FA) MainTab.DIVAN.faTitle else MainTab.DIVAN.enTitle,
                  maxLines = 1
                )
              },
              colors = NavigationBarItemDefaults.colors(
                selectedIconColor = PersianNightNavy,
                selectedTextColor = PersianGold,
                indicatorColor = PersianGold,
                unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f),
                unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
              ),
              modifier = Modifier.testTag("nav_item_divan")
            )

            // Bookmarks Tab
            NavigationBarItem(
              selected = currentTab == MainTab.BOOKMARKS,
              onClick = { currentTab = MainTab.BOOKMARKS },
              icon = {
                Icon(
                  imageVector = if (currentTab == MainTab.BOOKMARKS) Icons.Default.Bookmark else Icons.Outlined.BookmarkBorder,
                  contentDescription = MainTab.BOOKMARKS.faTitle
                )
              },
              label = {
                Text(
                  text = if (currentLanguage == AppLanguage.FA) MainTab.BOOKMARKS.faTitle else MainTab.BOOKMARKS.enTitle,
                  maxLines = 1
                )
              },
              colors = NavigationBarItemDefaults.colors(
                selectedIconColor = PersianNightNavy,
                selectedTextColor = PersianGold,
                indicatorColor = PersianGold,
                unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f),
                unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
              ),
              modifier = Modifier.testTag("nav_item_bookmarks")
            )

            // About Tab
            NavigationBarItem(
              selected = currentTab == MainTab.ABOUT,
              onClick = { currentTab = MainTab.ABOUT },
              icon = {
                Icon(
                  imageVector = if (currentTab == MainTab.ABOUT) Icons.Default.Info else Icons.Outlined.Info,
                  contentDescription = MainTab.ABOUT.faTitle
                )
              },
              label = {
                Text(
                  text = if (currentLanguage == AppLanguage.FA) MainTab.ABOUT.faTitle else MainTab.ABOUT.enTitle,
                  maxLines = 1
                )
              },
              colors = NavigationBarItemDefaults.colors(
                selectedIconColor = PersianNightNavy,
                selectedTextColor = PersianGold,
                indicatorColor = PersianGold,
                unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f),
                unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
              ),
              modifier = Modifier.testTag("nav_item_about")
            )
          }
        },
        snackbarHost = { SnackbarHost(snackbarHostState) },
        modifier = modifier.fillMaxSize()
      ) { innerPadding ->
        AnimatedContent(
          targetState = currentTab,
          transitionSpec = { fadeIn() togetherWith fadeOut() },
          modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
          label = "tab_transition"
        ) { tab ->
          when (tab) {
            MainTab.FAAL -> FaalScreen(
              repository = repository,
              currentLanguage = currentLanguage,
              isBookmarked = false,
              onToggleBookmark = { id -> repository.toggleBookmark(id) },
              snackbarHostState = snackbarHostState
            )
            MainTab.DIVAN -> DivanScreen(
              repository = repository,
              currentLanguage = currentLanguage,
              bookmarkedIds = bookmarkedIds,
              onToggleBookmark = { id -> repository.toggleBookmark(id) },
              onSelectGhazal = { ghazal -> selectedGhazalForDetail = ghazal }
            )
            MainTab.BOOKMARKS -> BookmarksScreen(
              repository = repository,
              currentLanguage = currentLanguage,
              bookmarkedIds = bookmarkedIds,
              onToggleBookmark = { id -> repository.toggleBookmark(id) },
              onSelectGhazal = { ghazal -> selectedGhazalForDetail = ghazal },
              onNavigateToDivan = { currentTab = MainTab.DIVAN }
            )
            MainTab.ABOUT -> AboutScreen(
              currentLanguage = currentLanguage
            )
          }
        }
      }
    }
  }
}
