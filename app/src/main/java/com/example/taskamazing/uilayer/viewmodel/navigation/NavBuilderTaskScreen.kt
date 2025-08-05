package com.example.taskamazing.uilayer.viewmodel.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.taskamazing.uilayer.viewmodel.TaskViewModel
import com.example.taskamazing.uilayer.viewmodel.screen.TaskScreenRoute

sealed class TaskScreenRouteSection(
    val route: String,
) {
    data object HomePage : TaskScreenRouteSection("HomePage")
    data object SideScreen : TaskScreenRouteSection("SideScreen/{variable}")

}

const val TaskScreenGroup = "TaskScreenGroup"



fun NavGraphBuilder.taskScreenSubGraph(viewModel: TaskViewModel) {
    navigation(route = TaskScreenGroup, startDestination = TaskScreenRouteSection.HomePage.route) {
        composable(TaskScreenRouteSection.HomePage.route) {
            TaskScreenRoute(
                viewmodel = viewModel
            )
        }
    }
}


