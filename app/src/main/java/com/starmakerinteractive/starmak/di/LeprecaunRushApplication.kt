package com.starmakerinteractive.starmak.di

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.onesignal.OneSignal
import com.starmakerinteractive.starmak.R
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class LeprecaunRushApplication : Application() {
    @Inject
    lateinit var appsFliinatAdasdfasStyletaoderacacerata: MutableLiveData<MutableMap<String, Any>>

    private val liinatAdasdfasStyletaoderacacer = object : AppsFlyerConversionListener {
        override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
            data?.let {
                appsFliinatAdasdfasStyletaoderacacerata.postValue(it)
            }
        }

        override fun onConversionDataFail(p0: String?) {}
        override fun onAppOpenAttribution(p0: MutableMap<String, String>?) {}
        override fun onAttributionFailure(p0: String?) {}
    }

    override fun onCreate() {
        super.onCreate()
        iawdwavawdwa()
    }

    private fun iawdwavawdwa() {
        advkavkdvak()
    }

    private fun advkavkdvak() {
        intiiawfdasavdawdv()

        OneSignal.initWithContext(this)
        OneSignal.setAppId(getString(R.string.one_signal_key))
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
    }

    private fun intiiawfdasavdawdv() {
        AppsFlyerLib.getInstance()
            .init(getString(R.string.apps_dev_key), liinatAdasdfasStyletaoderacacer, this)
        AppsFlyerLib.getInstance().start(this)
    }
}