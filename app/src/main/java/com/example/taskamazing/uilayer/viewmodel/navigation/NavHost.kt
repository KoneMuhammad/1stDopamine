package com.example.taskamazing.uilayer.viewmodel.screen.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.taskamazing.uilayer.viewmodel.TaskViewModel
import com.example.taskamazing.uilayer.viewmodel.screen.TaskScreenRoute


@Composable
fun NavigationHost(paddingValues: PaddingValues){
    val viewModel: TaskViewModel = hiltViewModel()
    val navController:NavHostController = rememberNavController()
    NavHost(navController = navController,
        startDestination = TaskScreenGroup) {
       TaskScreenSubGraph(viewModel)
    }
}