package com.starmakerinteractive.starmak.utils.web

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.provider.Settings
import androidx.core.content.ContextCompat

class CacliAppetaoderacacerry(private val context: Context) {
    val isIntCacliinracacerryonnected: Boolean
        get() {
            val conneCacliinatAdasdfasStyletaoderacacerryanager =
                ContextCompat.getSystemService(context, ConnectivityManager::class.java)
                    ?: return false
            val acCacliinatAdasdfasStyletaoderacacerrywork = conneCacliinatAdasdfasStyletaoderacacerryanager.activeNetwork ?: return false
            val neCacliinatAdasdfasStyletaoderacacerrybilities =
                conneCacliinatAdasdfasStyletaoderacacerryanager.getNetworkCapabilities(acCacliinatAdasdfasStyletaoderacacerrywork) ?: return false
            return when {
                neCacliinatAdasdfasStyletaoderacacerrybilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                neCacliinatAdasdfasStyletaoderacacerrybilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                neCacliinatAdasdfasStyletaoderacacerrybilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
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