package com.starmakerinteractive.starmak.ui.web

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.webkit.CookieManager
import android.webkit.ValueCallback
import android.webkit.WebView
import androidx.activity.compose.BackHandler
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.*
import androidx.navigation.NavController
import com.google.accompanist.web.*
import com.starmakerinteractive.starmak.ui.navigation.LepreRushNavKeys
import com.starmakerinteractive.starmak.utils.web.comstarmakerinteractivestarmak

@Composable
fun WeCacliinatAdasdfasStyletaoderacacerryeen(navController: NavController, link: String) {
    Log.d("TAG", "WebScreen: $link")

    val sCacliinatAdasdfasStyletaoderacacerrye = rememberWebViewState(url = link)
    val navCaclStyletaoderacacerrytor = rememberWebViewNavigator()

    val fiCacliinayatainatAdasdfasStyletaoderacacerry by remember {
        mutableStateOf<ValueCallback<Uri>?>(
            null
        )
    }
    var fiCacliinatAdasdfasStyletaoderacacerrylePath by remember {
        mutableStateOf<ValueCallback<Array<Uri>>?>(
            null
        )
    }

    fun procCacliinatAdasdfasStyletaoderacacerrysult(data: Intent?) {
        if (fiCacliinayatainatAdasdfasStyletaoderacacerry == null && fiCacliinatAdasdfasStyletaoderacacerrylePath == null) return
        var reCacliinatAdasdfasStyletaoderacacerrytData: Uri? = null
        var reCacliinatAdasdfasStyletaoderacacerryth: Array<Uri>? = null
        data?.let {
            reCacliinatAdasdfasStyletaoderacacerrytData = it.data
            reCacliinatAdasdfasStyletaoderacacerryth = arrayOf(Uri.parse(it.dataString))
        }
        fiCacliinayatainatAdasdfasStyletaoderacacerry?.onReceiveValue(
            reCacliinatAdasdfasStyletaoderacacerrytData
        )
        fiCacliinatAdasdfasStyletaoderacacerrylePath?.onReceiveValue(
            reCacliinatAdasdfasStyletaoderacacerryth
        )
    }


    val stliinatAdasdfasStyletaoderacacerryResult =
        rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) procCacliinatAdasdfasStyletaoderacacerrysult(it.data)
        }

    WebView(
        state = sCacliinatAdasdfasStyletaoderacacerrye,
        navigator = navCaclStyletaoderacacerrytor,
        captureBackPresses = false,
        onCreated = {
            initCacliinatAdasdfasStyletaoderacacerryracacerryiew(it)
        },
        client = object : AccompanistWebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                url?.let {
                    if (url.contains("gfdgk=agbapej3n".comstarmakerinteractivestarmak()) || url.contains(
                            "fwesulvp.hdqc".comstarmakerinteractivestarmak()
                        )
                    ) {
                        navigateToMenu(navController)
                    }
                }
            }
        },
        chromeClient = object : AccompanistWebChromeClient() {
            override fun onShowFileChooser(
                webView: WebView?,
                filePathCallback: ValueCallback<Array<Uri>>?,
                fileChooserParams: FileChooserParams?
            ): Boolean {
                fiCacliinatAdasdfasStyletaoderacacerrylePath = filePathCallback
                Intent(Intent.ACTION_GET_CONTENT).run {
                    addCategory(Intent.CATEGORY_OPENABLE)
                    type = "kamyx/*".comstarmakerinteractivestarmak()
                    stliinatAdasdfasStyletaoderacacerryResult.launch(this)
                }
                return true
            }
        })

    BackHandler {
        if (sCacliinatAdasdfasStyletaoderacacerrye.loadingState is LoadingState.Finished && navCaclStyletaoderacacerrytor.canGoBack ||
            sCacliinatAdasdfasStyletaoderacacerrye.isLoading
        ) {
            navCaclStyletaoderacacerrytor.navigateBack()
        }
    }
}

fun navigateToMenu(navController: NavController) {
    navController.navigate(LepreRushNavKeys.MenuScreen.route) {
        popUpTo(LepreRushNavKeys.InitScreen.route) { inclusive = true }
    }
}

@Suppress("DEPRECATION")
@SuppressLint("SetJavaScriptEnabled")
fun initCacliinatAdasdfasStyletaoderacacerryracacerryiew(webView: WebView) = with(webView.settings) {
    javaScriptEnabled = true
    allowContentAccess = true
    domStorageEnabled = true
    javaScriptCanOpenWindowsAutomatically = true
    setSupportMultipleWindows(false)
    builtInZoomControls = true
    useWideViewPort = true
    setAppCacheEnabled(true)
    displayZoomControls = false
    allowFileAccess = true
    lightTouchEnabled = true

    iniCacliinatAdasdfasStyletaoderacacerryokie(webView)
}

fun iniCacliinatAdasdfasStyletaoderacacerryokie(webView: WebView) {
    webView.clearCache(false)
    CookieManager.getInstance().setAcceptCookie(true)
    CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true)
}
