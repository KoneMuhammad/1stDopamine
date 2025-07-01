package com.example.taskamazing.locationbuilder

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import androidx.core.content.ContextCompat
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

 suspend fun getCurrentLocation(context: Context): Location? {
    return try {
        if (ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return null
        }

        val locationProvider = LocationServices.getFusedLocationProviderClient(context)

        suspendCancellableCoroutine<Location?> { cont ->
            locationProvider.lastLocation
                .addOnSuccessListener { location -> cont.resume(location) }
                .addOnFailureListener { cont.resume(null) }
        }
    } catch (e: SecurityException) {
        null
    }
}