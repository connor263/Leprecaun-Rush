package com.starmakerinteractive.starmak

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.appsflyer.AppsFlyerLib
import com.starmakerinteractive.starmak.ui.navigation.LepreRushNavKeys
import com.starmakerinteractive.starmak.ui.navigation.LeprecaunRushAppContent
import com.starmakerinteractive.starmak.ui.theme.LeprecaunRushTheme
import com.starmakerinteractive.starmak.ui.web.navigateToMenu
import com.starmakerinteractive.starmak.utils.web.CacliAppetaoderacacerry
import com.starmakerinteractive.starmak.utils.web.comstarmakerinteractivestarmak
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var appCacliinatAdasdfasStyletaoderacacerryLiveData: MutableLiveData<MutableMap<String, Any>>

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LeprecaunRushTheme {
                val navController = rememberNavController()
                val viewModel: MainActivityViewModel = hiltViewModel()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Transparent
                ) {
                    LeprecaunRushAppContent(navController = navController, viewModel)
                }
            }
        }
        inCtyletaoderacacerrypp()
    }

    fun inCtyletaoderacacerrypp() {
        Log.d("TAG", "initApp")
        viewModel.iCacliinatAdasdfasStyletaoderacacerrying = true
        if (!CacliAppetaoderacacerry(this).isIntCacliinracacerryonnected) {
            viewModel.iCacliinatAdasdfasStyletaoderacacerrying = false
            return
        }
        viewModel.getCacyletaoderacacerryeLink { link ->
            if (link.isBlank()) {

                viewModel.feCactaoderacacerryData { isUrlCorrect ->
                    if (isUrlCorrect) {
                        dpafsfafeesadksfs()
                    } else navigateToMenu()
                }

            } else navigateToWeb(link)
            Log.d("TAG", "initApp: cacheLink $link")
        }
    }

    private fun dpafsfafeesadksfs() = lifecycleScope.launch(Dispatchers.IO) {
        viewModel.setinatAdasdacacerrygle(this@MainActivity)
        withContext(Dispatchers.Main) {
            geCacliinatAdasderacacerryarams()
        }
    }

    private fun geCacliinatAdasderacacerryarams() {
        val ideracacerryd = AppsFlyerLib.getInstance().getAppsFlyerUID(this)
        viewModel.setCacliitaoderacacerryyerID(ideracacerryd)

        appCacliinatAdasdfasStyletaoderacacerryLiveData.observe(this) {
            it.forEach { inform ->
                when (inform.key) {
                    "ct_elttle".comstarmakerinteractivestarmak() -> viewModel.setCacliinatAdasdfasStyletaoderacacerrytus(
                        inform.value.toString()
                    )
                    "eoyhtixz".comstarmakerinteractivestarmak() -> viewModel.setCacliinatAdasdfasStyletaoderacacerrypaign(
                        inform.value.toString()
                    )
                    "ospat_sfgrmi".comstarmakerinteractivestarmak() -> viewModel.sacliisesasStyletaoderacacerry(
                        inform.value.toString()
                    )
                    "ct_oztneql".comstarmakerinteractivestarmak() -> viewModel.letaoderacacerryacliinatAdasdfasStyletaoderacacerrynnel(
                        inform.value.toString()
                    )
                }
            }
            colCaclracacerryLink()
        }
    }

    private fun colCaclracacerryLink() {
        if (CacliAppetaoderacacerry(this).isCacliinatAdasdfasStyletaoderacacerryoper && viewModel.chiiaoderacacerryrganic() ||
            viewModel.chCacliinderacacerryanicAccess()
        ) {
            navigateToMenu()
            return
        }

        viewModel.collCaderacacerryLink(this) { link ->
            navigateToWeb(link)
        }
    }

    private fun navigateToWeb(link: String) {
        val enCactaoderacacerryed = URLEncoder.encode(link, StandardCharsets.UTF_8.toString())
        viewModel.stringRoute = LepreRushNavKeys.WebScreen(enCactaoderacacerryed).route
    }

    private fun navigateToMenu() {
        viewModel.stringRoute = LepreRushNavKeys.MenuScreen.route
    }

}
