package com.example.taskamazing.uilayer.viewmodel.screen

import android.Manifest
import android.location.Location
import android.widget.Toast
import android.widget.VideoView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.app.ActivityCompat
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.example.taskamazing.locationbuilder.getCurrentLocation
import com.example.taskamazing.uilayer.viewmodel.TaskUiState
import com.example.taskamazing.uilayer.viewmodel.TaskViewModel
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import androidx.core.net.toUri
import com.example.taskamazing.datalayer.domainmodel.ModelTaskMessage
import com.example.taskamazing.datalayer.dto.ModelDTOTaskMessage
import com.example.taskamazing.datalayer.mapper.mapWeatherTypeToWeatherBackground
import com.google.accompanist.permissions.rememberPermissionState
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.query.Columns
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


/**
 * potentiall problems
 *  so after gotten from the repo or when getting got from the db in the repo
 *  it has to match. does it match?
 */

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun TaskScreenRoute(
    viewmodel: TaskViewModel = hiltViewModel(),
) {

        val uiState by viewmodel.uiState.collectAsState()
        val permissions = rememberPermissionState(Manifest.permission.ACCESS_COARSE_LOCATION)
        val context = LocalContext.current

        LaunchedEffect(Unit) {
            permissions.launchPermissionRequest()
        }

        LaunchedEffect(permissions.status.isGranted) {
            ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION)
            if (permissions.status.isGranted) {
                val currentLocation = getCurrentLocation(context)//runs then stores location
                val latitude = "${currentLocation?.latitude}"
                val longitude = "${currentLocation?.longitude}"

                viewmodel.LoadWeatherType(latitude, longitude, "1d7c51a33ea40c7e839c3aa734277761")

                val apiWeatherCondition = uiState.currentWeatherType?.description
                val isNightOrDay = uiState.currentWeatherType?.icon// null state doesnt change

                viewmodel.getWeatherBackground(mapWeatherTypeToWeatherBackground(apiWeatherCondition,isNightOrDay))


            }

        }

        TaskScreen(
            uiState = uiState,
            permissionGranted = permissions.status.isGranted,
            onClickAction = {}
        )
    }


    @Composable
    fun TaskScreen(
        uiState: TaskUiState,
        permissionGranted: Boolean,
        onClickAction: () -> Unit,
        modifier: Modifier = Modifier,
    ) {

        val match = uiState.modelTaskMessage.randomOrNull()
        val taskEmblem = match?.emblem_url
        val taskMessage = match?.task_message
        val taskVideo = uiState.modelTaskWeather?.video_url

        Column(
            modifier = modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .height(540.dp)
                    .width(300.dp)
                    .clip(RoundedCornerShape(20.dp)),
                        horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                VideoUrlWrapper(
                    videoUrl = taskVideo,
                    modifier = Modifier.fillMaxSize()
                )

                Row() {
                    if (taskMessage != null) {
                        Text(text = taskMessage)
                    }
                }
                AsyncImage(
                    model = taskEmblem,
                    contentDescription = null,
                    modifier = Modifier.size(60.dp)
                )


            }


        }
    }

@Composable
fun VideoUrlWrapper(videoUrl: String?, modifier: Modifier = Modifier) {
    AndroidView(
        modifier = Modifier,
        factory = { context ->
            VideoView(context).apply {
                setVideoURI(videoUrl?.toUri())
                setOnPreparedListener { it.isLooping = true }
                start()
            }
        }
    )
}
