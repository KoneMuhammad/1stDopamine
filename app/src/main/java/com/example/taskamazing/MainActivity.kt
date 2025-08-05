package com.example.taskamazing


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.taskamazing.ui.theme.TaskAmazingTheme
import com.example.taskamazing.uilayer.viewmodel.navigation.NavigationHost
import dagger.hilt.android.AndroidEntryPoint
import io.github.jan.supabase.SupabaseClient

import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var client: SupabaseClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskAmazingTheme {
                NavigationHost()
            }
        }
    }
}