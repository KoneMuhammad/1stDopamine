package com.example.taskamazing.uilayer.viewmodel.navigation

import kotlinx.serialization.Serializable


@Serializable
sealed interface TasksRoute{
    @Serializable   data object mainTasks: TasksRoute
    @Serializable  data object sideTasks: TasksRoute//apply plugin
}

sealed interface SettingsRoute{
    data object PreferencesRoute:SettingsRoute
    data object NotificationsRoute:SettingsRoute

}
