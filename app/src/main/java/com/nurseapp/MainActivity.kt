package com.nurseapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.nurseapp.ui.screens.HomeScreen
import com.nurseapp.ui.screens.ListaEnfermerosScreen
import com.nurseapp.ui.theme.NurseAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NurseAppTheme {

                var pantalla by remember {
                    mutableStateOf("home")
                }

                when (pantalla) {

                    "home" -> HomeScreen(
                        onLoginClick = {
                            // Pendiente de conectar Login
                        },
                        onNursesClick = {
                            pantalla = "lista"
                        },
                        onSearchClick = {
                            // Pendiente de conectar Búsqueda
                        }
                    )

                    "lista" -> ListaEnfermerosScreen(
                        onBackClick = {
                            pantalla = "home"
                        }
                    )
                }
            }
        }
    }
}
