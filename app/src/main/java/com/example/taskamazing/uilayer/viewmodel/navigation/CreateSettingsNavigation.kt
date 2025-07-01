package com.example.taskamazing.uilayer.viewmodel.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation


/**
 * navigation subgraph of main screen
 * navigation subgraph or settings screen
 *
 */

fun NavGraphBuilder.PreferenceSection(){
        navigation<PreferencesScreenRoute>(startDestination = PreferencesScreenRoute.SettingsScreenRoute){
                Composable<PreferencesScreenRoute.NotificationsRoute>(){/*a screen here)*/}
        }

}
