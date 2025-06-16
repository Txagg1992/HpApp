package com.curiousapps.footsies.ui.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.curiousapps.footsies.ui.theme.FootsiesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FootsiesTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "hog_list_screen"
                ) {
                    composable("hog_list_screen") {
                        HogListScreen(navController = navController)
                    }

                    composable(
                        "hog_detail_screen/{studentName}",
                        arguments = listOf(
                            navArgument("studentName") {
                                type = NavType.StringType
                            },
                        )
                    ) {
                        val studentName = remember {
                            it.arguments?.getString("studentName")
                        }
                        HogDetailScreen(
                            studentItem = studentName ?: "",
                            navController = navController
                        )
                    }
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
    FootsiesTheme {
        Greeting("Android")
    }
}