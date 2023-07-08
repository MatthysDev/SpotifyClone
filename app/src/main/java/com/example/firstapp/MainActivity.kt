package com.example.firstapp

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.firstapp.ui.screen.Home
import com.example.firstapp.ui.theme.FirstAppTheme


class MainActivity() : ComponentActivity() {
  @OptIn(ExperimentalMaterial3Api::class)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
      window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
      actionBar?.hide()
    setContent {
//            LaunchedEffect(key1 = Unit, block = {
//                val firebaseAuth = Firebase.auth
//
//                firebaseAuth.createUserWithEmailAndPassword("test@efficom.fr", "test12345").addOnCompleteListener {
//                    if (it.isSuccessful) {
//                        // Log in success
//
//
//                    } else if (it.isCanceled) {
//                        // Canceled
//
//                    }
//                }
//            })
        FirstAppTheme() {
        val navController = rememberNavController()
        NavHost(navController, startDestination = "home") {
          composable("home") { Home(navController = navController) }
        }
        }
      }
    }
  }


  @Composable
  fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
      text = "Hello $name!",
      modifier = modifier
    )
  }

  @Preview(showBackground = true)
  @Composable
  fun GreetingPreview() {
    FirstAppTheme {
      Greeting("Android")
    }
  }