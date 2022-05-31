package com.starmakerinteractive.starmak.ui.navigation

import android.content.pm.ActivityInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.starmakerinteractive.starmak.MainActivity
import com.starmakerinteractive.starmak.MainActivityViewModel
import com.starmakerinteractive.starmak.ui.game.slot.SlotScreen
import com.starmakerinteractive.starmak.ui.game.menu.MenuScreen
import com.starmakerinteractive.starmak.ui.game.menu.MenuViewModel
import com.starmakerinteractive.starmak.ui.game.slot.SlotViewModel
import com.starmakerinteractive.starmak.ui.game.wheel.WheelScreen
import com.starmakerinteractive.starmak.ui.game.wheel.WheelViewModel

@Composable
fun LeprecaunRushAppContent(navController: NavHostController, viewModel: MainActivityViewModel) {
    val context = LocalContext.current

    NavHost(navController = navController, startDestination = "menu") {
        composable("menu") {
            val menuViewModel: MenuViewModel = hiltViewModel()
            MenuScreen(navController, menuViewModel)
        }
        composable("slot") {
            val slotViewModel:SlotViewModel = hiltViewModel()
            SlotScreen(navController,slotViewModel)
        }
        composable("wheel") {
            val wheelViewModel: WheelViewModel = hiltViewModel()
            WheelScreen(navController,wheelViewModel)
        }
    }

    LaunchedEffect(viewModel.stringRoute.value) {
        val route = viewModel.stringRoute.value
        if (route.isNotBlank()) {
            navController.navigate(route) {
                popUpTo("init") { inclusive = true }
            }
        }
    }

    DisposableEffect(Unit) {
        val activity = (context as MainActivity)
        val originalOrientation = activity.requestedOrientation
        activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        onDispose {
            activity.requestedOrientation = originalOrientation
        }
    }
}