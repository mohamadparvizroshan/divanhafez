package com.example.ui.screens

import androidx.compose.foundation.Image
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.model.AppLanguage
import com.example.ui.components.GoldFrameCard
import com.example.ui.components.TazhibDivider
import com.example.ui.theme.AmiriFontFamily
import com.example.ui.theme.PersianGold
import com.example.ui.theme.PersianGoldAmber
import com.example.ui.theme.PersianGoldLight
import com.example.ui.theme.PersianTurquoise
import com.example.ui.theme.PlayfairFontFamily

@Composable
fun AboutScreen(
  currentLanguage: AppLanguage,
  modifier: Modifier = Modifier
) {
  LazyColumn(
    modifier = modifier
      .fillMaxSize()
      .testTag("about_screen_content"),
    contentPadding = PaddingValues(16.dp),
    verticalArrangement = Arrangement.spacedBy(16.dp)
  ) {
    // Header Avatar Card
    item {
      GoldFrameCard(
        modifier = Modifier.fillMaxWidth(),
        cornerRadius = 20.dp
      ) {
        Column(
          modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Box(
            modifier = Modifier
              .size(90.dp)
              .clip(CircleShape)
              .border(2.dp, PersianGold, CircleShape),
            contentAlignment = Alignment.Center
          ) {
            Image(
              painter = painterResource(id = R.drawable.ic_hafez_logo),
              contentDescription = "Hafez Emblem",
              modifier = Modifier.fillMaxSize(),
              contentScale = ContentScale.Crop
            )
          }

          Spacer(modifier = Modifier.height(14.dp))

          Text(
            text = if (currentLanguage == AppLanguage.FA)
              "خواجه شمس‌الدین محمد حافظ شیرازی"
            else
              "Khwaja Shams-ud-Din Muhammad Hafez",
            style = MaterialTheme.typography.titleLarge.copy(
              fontFamily = if (currentLanguage == AppLanguage.FA) AmiriFontFamily else PlayfairFontFamily,
              fontWeight = FontWeight.Bold,
              color = PersianGold
            ),
            textAlign = TextAlign.Center
          )

          Spacer(modifier = Modifier.height(4.dp))

          Text(
            text = if (currentLanguage == AppLanguage.FA)
              "لسان‌الغیب و ترجمان‌الاسرار (۷۲۷ - ۷۹۲ هـ.ق)"
            else
              "The Tongue of the Unseen & Interpreter of Mysteries (1315 – 1390 CE)",
            style = MaterialTheme.typography.bodySmall.copy(
              color = PersianTurquoise
            ),
            textAlign = TextAlign.Center
          )

          TazhibDivider(modifier = Modifier.padding(vertical = 12.dp))

          Text(
            text = if (currentLanguage == AppLanguage.FA)
              "«چو بشنوی سخن اهل دل مگو که خطاست\nسخن‌شناس نه‌ای جان من خطا این جاست»"
            else
              "“When you hear the speech of enlightened souls, say not that it is mistaken;\nYou are not versed in deep wisdom, my dear—the mistake lies right here!”",
            style = MaterialTheme.typography.bodyMedium.copy(
              fontFamily = if (currentLanguage == AppLanguage.FA) AmiriFontFamily else PlayfairFontFamily,
              color = PersianGoldLight,
              textAlign = TextAlign.Center
            )
          )
        }
      }
    }

    // Tradition of Faal-e Hafez
    item {
      Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        shape = RoundedCornerShape(16.dp)
      ) {
        Column(modifier = Modifier.padding(18.dp)) {
          Text(
            text = if (currentLanguage == AppLanguage.FA) "سنت دیرینه فال حافظ" else "The Timeless Tradition of Faal",
            style = MaterialTheme.typography.titleMedium.copy(
              color = PersianGold,
              fontWeight = FontWeight.Bold
            )
          )

          Spacer(modifier = Modifier.height(8.dp))

          Text(
            text = if (currentLanguage == AppLanguage.FA)
              "فال حافظ یکی از کهن‌ترین و دلنشین‌ترین آیین‌های فرهنگی و معنوی ایرانیان است. در لحظات مهم زندگی، جشن‌های کهن نظیر شب یلدا و نوروز، ایرانیان با وضو و نیت خالصانه دیوان خواجه را می‌گشایند و کلام او را آیینه سرنوشت و راهنمای روح می‌دانند."
            else
              "Faal-e Hafez is one of the most cherished poetic traditions in Persian culture. During sacred celebrations such as Yalda Night and Nowruz, and whenever facing crossroads in life, seekers consult Hafez's Divan as an oracle of the soul.",
            style = MaterialTheme.typography.bodyMedium.copy(
              lineHeight = 24.sp
            )
          )
        }
      }
    }

    // Bilingual & Cultural Bridges
    item {
      Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        shape = RoundedCornerShape(16.dp)
      ) {
        Column(modifier = Modifier.padding(18.dp)) {
          Text(
            text = if (currentLanguage == AppLanguage.FA) "پل دو زبانه و تلفظ آوانگاری" else "Bilingual Experience & Phonetics",
            style = MaterialTheme.typography.titleMedium.copy(
              color = PersianGold,
              fontWeight = FontWeight.Bold
            )
          )

          Spacer(modifier = Modifier.height(8.dp))

          Text(
            text = if (currentLanguage == AppLanguage.FA)
              "این برنامه با هدف پیوند نسل‌ها و آشنایی جهانیان با شاهکار شعر فارسی طراحی شده است. هر غزل دارای ترجمه انگلیسی روان و آوانگاری (Transliteration) است تا حتی کسانی که قادر به خواندن خط فارسی نیستند بتوانند طنین موسیقایی اشعار را بر زبان جاری سازند."
            else
              "This application bridges cultural horizons. Each ghazal is coupled with elegant English interpretations and precise phonetic transliteration, allowing world poetry lovers to chant Hafez's verses in their authentic lyrical rhythm.",
            style = MaterialTheme.typography.bodyMedium.copy(
              lineHeight = 24.sp
            )
          )
        }
      }
    }

    // Architectural & Design homage
    item {
      Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        shape = RoundedCornerShape(16.dp)
      ) {
        Column(modifier = Modifier.padding(18.dp)) {
          Text(
            text = if (currentLanguage == AppLanguage.FA) "طراحی اصیل ایرانی (Modern Persian UI)" else "Design Philosophy",
            style = MaterialTheme.typography.titleMedium.copy(
              color = PersianGold,
              fontWeight = FontWeight.Bold
            )
          )

          Spacer(modifier = Modifier.height(8.dp))

          Text(
            text = if (currentLanguage == AppLanguage.FA)
              "ترکیب رنگ‌های لاجوردی شبانه شیراز، طلای کهنه، تذهیب‌های اسلیمی و تایپوگرافی اصیل وزیرمتن و امیری، حس حضور در یک نسخه خطی نفیس را در قالبی مدرن و کاربرپسند به ارمغان آورده است."
            else
              "Harmonizing Midnight Lapis, Antique Gold illumination, arabesque scrollwork, and classical Persian typography—evoking the majesty of an illuminated manuscript in modern form.",
            style = MaterialTheme.typography.bodyMedium.copy(
              lineHeight = 24.sp
            )
          )
        }
      }
    }

    item {
      Spacer(modifier = Modifier.height(24.dp))
    }
  }
}
