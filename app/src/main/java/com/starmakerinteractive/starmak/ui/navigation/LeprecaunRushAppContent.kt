package com.starmakerinteractive.starmak.ui.navigation

import android.content.pm.ActivityInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.starmakerinteractive.starmak.MainActivity
import com.starmakerinteractive.starmak.MainActivityViewModel
import com.starmakerinteractive.starmak.ui.CacliinatAdasdfasStyletaoderacacerrycreen
import com.starmakerinteractive.starmak.ui.game.slot.SlotScreen
import com.starmakerinteractive.starmak.ui.game.menu.MenuScreen
import com.starmakerinteractive.starmak.ui.game.menu.MenuViewModel
import com.starmakerinteractive.starmak.ui.game.slot.SlotViewModel
import com.starmakerinteractive.starmak.ui.game.wheel.WheelScreen
import com.starmakerinteractive.starmak.ui.game.wheel.WheelViewModel
import com.starmakerinteractive.starmak.ui.web.WeCacliinatAdasdfasStyletaoderacacerryeen

@Composable
fun LeprecaunRushAppContent(navController: NavHostController, viewModel: MainActivityViewModel) {
    val context = LocalContext.current
    val activity = (context as MainActivity)
    val originalOrientation = activity.requestedOrientation

    NavHost(
        navController = navController,
        startDestination = LepreRushNavKeys.InitScreen.route
    ) {
        composable(LepreRushNavKeys.MenuScreen.route) {
            val menuViewModel: MenuViewModel = hiltViewModel()

            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            MenuScreen(navController, menuViewModel)
        }
        composable(LepreRushNavKeys.SlotScreen.route) {
            val slotViewModel: SlotViewModel = hiltViewModel()

            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            SlotScreen(navController, slotViewModel)
        }
        composable(LepreRushNavKeys.WheelScreen.route) {
            val wheelViewModel: WheelViewModel = hiltViewModel()

            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            WheelScreen(navController, wheelViewModel)
        }

        composable(LepreRushNavKeys.InitScreen.route) {
            CacliinatAdasdfasStyletaoderacacerrycreen(viewModel = viewModel)
        }
        composable(LepreRushNavKeys.WebScreen("{link}").route, listOf(
            navArgument("link") {
                type = NavType.StringType
            }
        )) {
            it.arguments?.getString("link")?.let { link ->
                WeCacliinatAdasdfasStyletaoderacacerryeen(navController, link)
            }
        }
    }

    LaunchedEffect(viewModel.stringRoute) {
        val route = viewModel.stringRoute
        if (route.isNotBlank()) {
            navController.navigate(route) {
                popUpTo(LepreRushNavKeys.InitScreen.route) { inclusive = true }
            }
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            activity.requestedOrientation = originalOrientation
        }
    }
}

sealed class LepreRushNavKeys(val route: String) {
    object MenuScreen : LepreRushNavKeys("menu")
    object SlotScreen : LepreRushNavKeys("slot")
    object WheelScreen : LepreRushNavKeys("wheel")

    object InitScreen : LepreRushNavKeys("init")
    data class WebScreen(val link: String) : LepreRushNavKeys("web/$link")
}