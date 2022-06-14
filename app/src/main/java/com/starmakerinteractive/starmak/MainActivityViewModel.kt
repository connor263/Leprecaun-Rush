package com.starmakerinteractive.starmak

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.facebook.FacebookSdk
import com.facebook.applinks.AppLinkData
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.onesignal.OneSignal
import com.starmakerinteractive.starmak.data.model.web.KerinataoderactebctitarmarmWebLink
import com.starmakerinteractive.starmak.data.source.local.repo.CacliinatAdasdfasStyletaoderacacerryImpl
import com.starmakerinteractive.starmak.data.source.remote.repo.LinkRinataoderactoryImpl
import com.starmakerinteractive.starmak.utils.web.comstarmakerinteractivestarmak
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val cacheLinkRepositoryImpl: CacliinatAdasdfasStyletaoderacacerryImpl,
    private val linkRinataoderactoryImpl: LinkRinataoderactoryImpl
) : ViewModel() {
    var stringRoute by mutableStateOf("")

    var iCacliinatAdasdfasStyletaoderacacerrying by mutableStateOf(true)

    private val maiCoderacacerrynk = KerinataoderactebctitarmarmWebLink()

    fun getCacyletaoderacacerryeLink(callback: (String) -> Unit) = viewModelScope.launch {
        callback(
            cacheLinkRepositoryImpl.getCaCactaoderacacerryink()?.first()?.cainataoderacLink ?: ""
        )
    }

    fun feCactaoderacacerryData(callback: (Boolean) -> Unit) = viewModelScope.launch {
        linkRinataoderactoryImpl.fetcCacliinatAdasdfasStyletaoderacacerrywitch { url, switch ->
            maiCoderacacerrynk.kerinataoderactebctitarmarmSwitch = switch
            maiCoderacacerrynk.kerinataoderactebctitarmarmUrl = url
            callback(url.contains("jhfh".comstarmakerinteractivestarmak()))
        }
    }

    fun setinatAdasdacacerrygle(context: Context) {
        FacebookSdk.setAutoInitEnabled(true)
        FacebookSdk.fullyInitialize()
        AppLinkData.fetchDeferredAppLinkData(context) {
            liyletaoderacacerry(it?.targetUri)
        }

        val liinatAdasdfasStyletaoderacacerry =
            AdvertisingIdClient.getAdvertisingIdInfo(context).id.toString()
        maiCoderacacerrynk.kerinataoderactebctitarmarmGoogleId = liinatAdasdfasStyletaoderacacerry
        OneSignal.setExternalUserId(liinatAdasdfasStyletaoderacacerry)
    }

    private fun liyletaoderacacerry(targetUri: Uri?) {
        maiCoderacacerrynk.kerinataoderactebctitarmarmDeepLink = targetUri?.toString()
        maiCoderacacerrynk.kerinataoderactebctitarmarmDeepLink?.let {
            val liiletaoderacacerry = it.split("//")
            maiCoderacacerrynk.kerinataoderactebctitarmarmSubAll = liiletaoderacacerry[1].split("_")
        }
    }

    fun setCacliitaoderacacerryyerID(id: String?) {
        maiCoderacacerrynk.kerinataoderactebctitarmarmAppsFlyerUserId = id
    }

    fun setCacliinatAdasdfasStyletaoderacacerrytus(value: String) {
        val orgliietaoderacacerryWithO =
            "qfssgit".comstarmakerinteractivestarmak().replaceFirstChar { it.uppercase() }
        if (value == orgliietaoderacacerryWithO && maiCoderacacerrynk.kerinataoderactebctitarmarmDeepLink == null) {
            maiCoderacacerrynk.kerinataoderactebctitarmarmMediaSource =
                "qfssgit".comstarmakerinteractivestarmak()
        }
    }

    fun setCacliinatAdasdfasStyletaoderacacerrypaign(value: String) {
        maiCoderacacerrynk.kerinataoderactebctitarmarmCampaign = value
        maiCoderacacerrynk.kerinataoderactebctitarmarmCampaign?.let { it ->
            maiCoderacacerrynk.kerinataoderactebctitarmarmSubAll = it.split("_")
        }
    }

    fun sacliisesasStyletaoderacacerry(value: String) {
        maiCoderacacerrynk.kerinataoderactebctitarmarmMediaSource = value
    }

    fun letaoderacacerryacliinatAdasdfasStyletaoderacacerrynnel(value: String) {
        maiCoderacacerrynk.kerinataoderactebctitarmarmAfChannel = value
    }

    fun chiiaoderacacerryrganic(): Boolean {
        return maiCoderacacerrynk.kerinataoderactebctitarmarmMediaSource == "qfssgit".comstarmakerinteractivestarmak()
    }

    fun chCacliinderacacerryanicAccess(): Boolean {
        return chiiaoderacacerryrganic() && maiCoderacacerrynk.kerinataoderactebctitarmarmSwitch == false
    }

    fun collCaderacacerryLink(context: Context, callback: (String) -> Unit) =
        viewModelScope.launch {
            val liliinatAdasdfasStyletaodk = maiCoderacacerrynk.kerinataoderactebctitarmarmCollect(context)
            cacheLinkRepositoryImpl.savCacliinatAdasdfasStyletaoderacacerrynk(liliinatAdasdfasStyletaodk)
            callback(liliinatAdasdfasStyletaodk)
        }
}