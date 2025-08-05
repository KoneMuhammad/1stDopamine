package com.example.taskamazing.uilayer.viewmodel.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.taskamazing.uilayer.viewmodel.TaskViewModel


@Composable
fun NavigationHost(){
    val viewModel: TaskViewModel = hiltViewModel()
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = TaskScreenGroup

    ) {
       taskScreenSubGraph(viewModel)
    }
}
