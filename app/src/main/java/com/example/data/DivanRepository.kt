package com.example.data

import android.content.Context
import android.content.SharedPreferences
import com.example.model.Ghazal
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.random.Random

class DivanRepository(context: Context) {
  private val prefs: SharedPreferences =
    context.getSharedPreferences("divan_hafez_prefs", Context.MODE_PRIVATE)

  private val _bookmarkedIds = MutableStateFlow<Set<Int>>(emptySet())
  val bookmarkedIds: StateFlow<Set<Int>> = _bookmarkedIds.asStateFlow()

  private val _recentFaalHistory = MutableStateFlow<List<Int>>(emptyList())
  val recentFaalHistory: StateFlow<List<Int>> = _recentFaalHistory.asStateFlow()

  init {
    loadBookmarks()
  }

  private fun loadBookmarks() {
    val saved = prefs.getStringSet("bookmarked_ghazals", emptySet()) ?: emptySet()
    _bookmarkedIds.value = saved.mapNotNull { it.toIntOrNull() }.toSet()
  }

  fun toggleBookmark(ghazalId: Int) {
    val current = _bookmarkedIds.value.toMutableSet()
    if (current.contains(ghazalId)) {
      current.remove(ghazalId)
    } else {
      current.add(ghazalId)
    }
    _bookmarkedIds.value = current
    prefs.edit()
      .putStringSet("bookmarked_ghazals", current.map { it.toString() }.toSet())
      .apply()
  }

  fun isBookmarked(ghazalId: Int): Boolean {
    return _bookmarkedIds.value.contains(ghazalId)
  }

  fun getAllGhazals(): List<Ghazal> = HafezPoemsData.poems

  fun getGhazalById(id: Int): Ghazal? = HafezPoemsData.poems.find { it.id == id }

  fun searchGhazals(query: String): List<Ghazal> {
    if (query.isBlank()) return HafezPoemsData.poems
    val clean = query.trim().lowercase()

    return HafezPoemsData.poems.filter { ghazal ->
      ghazal.number.toString() == clean ||
        ghazal.titleFa.contains(clean, ignoreCase = true) ||
        ghazal.titleEn.contains(clean, ignoreCase = true) ||
        ghazal.themeFa.contains(clean, ignoreCase = true) ||
        ghazal.themeEn.contains(clean, ignoreCase = true) ||
        ghazal.verses.any { v ->
          v.firstHalfFa.contains(clean, ignoreCase = true) ||
            v.secondHalfFa.contains(clean, ignoreCase = true) ||
            v.translationEn.contains(clean, ignoreCase = true) ||
            v.transliteration.contains(clean, ignoreCase = true)
        }
    }
  }

  fun getRandomFaal(): Ghazal {
    val list = HafezPoemsData.poems
    val randomIndex = Random.nextInt(list.size)
    val chosen = list[randomIndex]
    val updatedHistory = listOf(chosen.id) + (_recentFaalHistory.value.filter { it != chosen.id })
    _recentFaalHistory.value = updatedHistory.take(10)
    return chosen
  }

  fun getDailyGhazal(): Ghazal {
    val list = HafezPoemsData.poems
    // Stable daily index based on day of year
    val dayOfYear = java.util.Calendar.getInstance().get(java.util.Calendar.DAY_OF_YEAR)
    val index = dayOfYear % list.size
    return list[index]
  }
}
