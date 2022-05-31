package com.starmakerinteractive.starmak.ui.game.menu

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.starmakerinteractive.starmak.MainActivity
import com.starmakerinteractive.starmak.R
import com.starmakerinteractive.starmak.ui.game.views.MenuButton

@Composable
fun MenuScreen(navController: NavController, viewModel: MenuViewModel) {
    val activity = LocalContext.current as MainActivity
    val scoreModel = viewModel.scoreModel.collectAsState(initial = null)
    Image(
        modifier = Modifier.fillMaxSize(),
        painter = painterResource(id = R.drawable.game_bg_4),
        contentDescription = null,
        contentScale = ContentScale.FillBounds
    )
    Row(
        modifier = Modifier
            .fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(0.5F)
                .background(
                    brush = Brush.radialGradient(
                        listOf(
                            Color.Black.copy(alpha = 0.8F),
                            Color.Transparent
                        )
                    )
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MenuButton(text = "Start") {
                navController.navigate("slot")
            }
            MenuButton(
                text = "Score: ${scoreModel.value?.score ?: 0}",
                style = TextStyle(fontSize = 20.sp)
            ) {
                Toast.makeText(
                    activity,
                    "Score: ${scoreModel.value?.score ?: 0}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        Column(
            modifier = Modifier
                .weight(0.5F)
                .background(
                    brush = Brush.radialGradient(
                        listOf(
                            Color.Black.copy(alpha = 0.8F),
                            Color.Transparent
                        )
                    )
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MenuButton(text = "Leprecaun Wheel") {
                navController.navigate("wheel")
            }

            MenuButton(text = "Exit") {
                activity.finish()
            }
        }
    }
}