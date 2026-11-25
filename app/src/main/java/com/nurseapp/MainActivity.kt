package com.nurseapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.nurseapp.ui.screens.HomeScreen
import com.nurseapp.ui.theme.NurseAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NurseAppTheme {
                HomeScreen(
                    onLoginClick = {},
                    onNursesClick = {},
                    onSearchClick = {}
                )
            }
        }
    }
}