package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.data.DivanRepository
import com.example.ui.HafezMainScreen
import com.example.ui.theme.HafezTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()

    val repository = DivanRepository(applicationContext)

    setContent {
      var isDarkTheme by remember { mutableStateOf(true) }

      HafezTheme(darkTheme = isDarkTheme) {
        HafezMainScreen(
          repository = repository,
          isDarkTheme = isDarkTheme,
          onToggleDarkTheme = { isDarkTheme = !isDarkTheme },
          modifier = Modifier.fillMaxSize()
        )
      }
    }
  }
}
