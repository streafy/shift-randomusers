package com.streafy.shiftrandomusers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.streafy.shiftrandomusers.core.ui.theme.ShiftRandomUsersTheme
import com.streafy.shiftrandomusers.navigation.AppNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShiftRandomUsersTheme {
                AppNavHost()
            }
        }
    }
}