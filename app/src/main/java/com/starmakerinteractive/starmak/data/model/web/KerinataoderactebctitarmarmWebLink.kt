package com.starmakerinteractive.starmak.data.model.web

import android.content.Context
import com.starmakerinteractive.starmak.R
import com.starmakerinteractive.starmak.utils.web.comstarmakerinteractivestarmak


data class KerinataoderactebctitarmarmWebLink(
    var kerinataoderactebctitarmarmGoogleId: String? = null,
    var kerinataoderactebctitarmarmAppsFlyerUserId: String? = null,
    var kerinataoderactebctitarmarmSubAll: List<String> = listOf("", "", "", "", "", "", "", "", "", ""),
    var kerinataoderactebctitarmarmDeepLink: String? = null,
    var kerinataoderactebctitarmarmMediaSource: String? = null,
    var kerinataoderactebctitarmarmAfChannel: String? = null,
    var kerinataoderactebctitarmarmCampaign: String? = null,
    var kerinataoderactebctitarmarmUrl: String? = null,
    var kerinataoderactebctitarmarmSwitch: Boolean? = null
) {
    fun kerinataoderactebctitarmarmCollect(context: Context): String {
        val kerinataoderactebctitarmarmResources = context.resources
        val kerinataoderactebctitarmarmPackageName = context.packageName
        val kerinataoderactebctitarmarmAppsFlyerDevKey = kerinataoderactebctitarmarmResources.getString(R.string.apps_dev_key)
        val kerinataoderactebctitarmarmFbToken = kerinataoderactebctitarmarmResources.getString(R.string.fb_at)
        val kerinataoderactebctitarmarmFbAppId = kerinataoderactebctitarmarmResources.getString(R.string.fb_app_id)

        var kerinataoderactebctitarmarmIndex = 0
        val kerinataoderactebctitarmarmSubsString = kerinataoderactebctitarmarmSubAll.joinToString(separator = "") {
            kerinataoderactebctitarmarmIndex++
            "&sub$kerinataoderactebctitarmarmIndex=$it"
        }

        val kerinataotitarmarmStrMediaSource = "?ospat_sfgrmi=".comstarmakerinteractivestarmak()
        val kerinataotitarmarmStrGoogleId = "&icayee_rpin=".comstarmakerinteractivestarmak()
        val kerinataotitarmarmStrAppsFlyerUserId = "&ct_gkxrzp=".comstarmakerinteractivestarmak()
        val kerinataotitarmarmStrPackageName = "&dizvee=".comstarmakerinteractivestarmak()
        val kerinataotitarmarmStrAppsFlyerDevKey = "&fsh_cxy=".comstarmakerinteractivestarmak()
        val kerinataotitarmarmStrFbToken = "&hp_ml=".comstarmakerinteractivestarmak()
        val kerinataotitarmarmStrFbAppId = "&hp_mhi_iu=".comstarmakerinteractivestarmak()
        val kerinataotitarmarmStrAfChannel = "&ct_oztneql=".comstarmakerinteractivestarmak()
        val kerinataotitarmarmStrCampaign = "&eoyhtixz=".comstarmakerinteractivestarmak()

        return "${this.kerinataoderactebctitarmarmUrl}" +
                "$kerinataotitarmarmStrMediaSource${this.kerinataoderactebctitarmarmMediaSource}" +
                "$kerinataotitarmarmStrGoogleId${this.kerinataoderactebctitarmarmGoogleId}" +
                "$kerinataotitarmarmStrAppsFlyerUserId${this.kerinataoderactebctitarmarmAppsFlyerUserId}" +
                "$kerinataotitarmarmStrPackageName$kerinataoderactebctitarmarmPackageName" +
                "$kerinataotitarmarmStrAppsFlyerDevKey$kerinataoderactebctitarmarmAppsFlyerDevKey" +
                "$kerinataotitarmarmStrFbToken$kerinataoderactebctitarmarmFbToken" +
                "$kerinataotitarmarmStrFbAppId$kerinataoderactebctitarmarmFbAppId" +
                "$kerinataotitarmarmStrAfChannel${this.kerinataoderactebctitarmarmAfChannel}" +
                "$kerinataotitarmarmStrCampaign${this.kerinataoderactebctitarmarmCampaign}" +
                kerinataoderactebctitarmarmSubsString

    }
}
