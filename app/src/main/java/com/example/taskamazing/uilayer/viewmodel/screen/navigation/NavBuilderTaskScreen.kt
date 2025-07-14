package com.example.taskamazing.uilayer.viewmodel.screen

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.taskamazing.uilayer.viewmodel.TaskViewModel
import kotlinx.serialization.Serializable
import okhttp3.internal.concurrent.Task

/**
 * navigation for main screen
 */
const val TaskSectionRoute: String = "TaskSectionRoute"
const val TaskScreenBaseRoute: String = "TaskScreenBaseRoute"
const val TaskScreenSideRoute: String = "TaskScreenSideRoute"
const val TaskScreenBaseRoute: String = "TaskScreenBaseRoute"
const val TaskScreenBaseRoute: String = "TaskScreenBaseRoute"

/**
 * have navigation type which isa route name
 *
 */
fun NavGraphBuilder.TaskScreenSection(viewModel: TaskViewModel) {
    navigation(route = TaskSectionRoute, startDestination = "TaskMainScreen") {
        composable("TaskMainScreen") {
            TaskScreenRoute(
                viewmodel = viewModel
            )
        }
        composable("TaskSideScreen"){

        }
    }
}


fun xyz() {
    NavHost(navController =) { }
}

fun NavController.xyz() {
    navigate(route =)
}

