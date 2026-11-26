package com.nurseapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.nurseapp.ui.screens.HomeScreen
import com.nurseapp.ui.screens.LoginScreen
import com.nurseapp.ui.screens.NurseListScreen
import com.nurseapp.ui.screens.SearchNursesScreen
import com.nurseapp.ui.theme.NurseAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NurseAppTheme {

                var pantalla by remember {
                    mutableStateOf(1)
                }

                when (pantalla) {

                    1 -> HomeScreen(
                        onLoginClick = { pantalla = 2 },
                        onNursesClick = { pantalla = 3 },
                        onSearchClick = { pantalla = 4 }
                    )

                    2 -> LoginScreen(
                        onBackClick = { pantalla = 1 }
                    )

                    3 -> NurseListScreen(
                        onBackClick = { pantalla = 1 }
                    )

                    4 -> SearchNursesScreen(
                        onBackClick = { pantalla = 1 }
                    )
                }
            }
        }
    }
}