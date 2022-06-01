package com.starmakerinteractive.starmak.utils.web

import android.content.Context
import android.net.ConnectivityManager
import android.provider.Settings
import androidx.core.content.ContextCompat


class CacliAppetaoderacacerry(private val context: Context) {
    val isIntCacliinracacerryonnected: Boolean
        get() {
            val conneCacliinatAdasdfasStyletaoderacacerryanager =
                ContextCompat.getSystemService(context, ConnectivityManager::class.java)
                    ?: return false
            val netiinatAdasdfasStyletaoderanfo = conneCacliinatAdasdfasStyletaoderacacerryanager.activeNetworkInfo
            return netiinatAdasdfasStyletaoderanfo != null && netiinatAdasdfasStyletaoderanfo.isConnected
        }

    val isCacliinatAdasdfasStyletaoderacacerryoper: Boolean
        get() {
            return Settings.Secure.getInt(
                context.contentResolver,
                Settings.Global.DEVELOPMENT_SETTINGS_ENABLED,
                0
            ) == 1
        }
}