package com.example.taskamazing.uilayer.viewmodel.screen

import android.content.Context
import android.widget.Toast

fun showPermissionDeniedMessage(context: Context) {
    Toast.makeText(
        context,
        "I respect you want privacy,and if you want specific weather background i need your Location",
        Toast.LENGTH_LONG
    ).show()


}
