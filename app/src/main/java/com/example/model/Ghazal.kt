package com.example.model

data class Verse(
  val firstHalfFa: String,
  val secondHalfFa: String,
  val translationEn: String,
  val transliteration: String
)

data class Interpretation(
  val verdictFa: String,
  val verdictEn: String,
  val messageFa: String,
  val messageEn: String,
  val adviceFa: String,
  val adviceEn: String
)

data class Ghazal(
  val id: Int,
  val number: Int,
  val titleFa: String,
  val titleEn: String,
  val themeFa: String,
  val themeEn: String,
  val verses: List<Verse>,
  val interpretation: Interpretation
) {
  val fullTextFa: String
    get() = verses.joinToString("\n") { "${it.firstHalfFa} / ${it.secondHalfFa}" }

  val fullTextEn: String
    get() = verses.joinToString("\n") { it.translationEn }
}

enum class AppLanguage(val code: String, val displayName: String) {
  FA("fa", "فارسی"),
  EN("en", "English")
}

enum class MainTab(val faTitle: String, val enTitle: String) {
  FAAL("فال حافظ", "Faal-e Hafez"),
  DIVAN("دیوان اشعار", "The Divan"),
  BOOKMARKS("نشان‌شده‌ها", "Bookmarks"),
  ABOUT("درباره حافظ", "About Hafez")
}
