package com.starmakerinteractive.starmak.ui.game.wheel

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.starmakerinteractive.starmak.R
import com.starmakerinteractive.starmak.ui.game.views.BackButton
import com.starmakerinteractive.starmak.ui.game.views.MenuButton
import kotlinx.coroutines.delay
import nl.dionsegijn.konfetti.compose.KonfettiView
import nl.dionsegijn.konfetti.core.Party
import nl.dionsegijn.konfetti.core.Position
import nl.dionsegijn.konfetti.core.emitter.Emitter
import java.util.concurrent.TimeUnit

@Composable
fun WheelScreen(navController: NavController, viewModel: WheelViewModel) {
    val scoreModel = viewModel.scoreModel.collectAsState(initial = null)
    val wheelAnim = remember { Animatable(0F) }

    Image(
        modifier = Modifier.fillMaxSize(),
        painter = painterResource(id = R.drawable.game_bg_5),
        contentDescription = null,
        contentScale = ContentScale.FillBounds
    )

    BackButton(text = "Back") {
        navController.navigateUp()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            modifier = Modifier.weight(0.15F),
            text = "Score: ${scoreModel.value?.score ?: 0}",
            fontSize = 28.sp,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(4.dp))
        Box(modifier = Modifier.weight(0.60F), contentAlignment = Alignment.TopCenter) {
            Image(
                modifier = Modifier.rotate(wheelAnim.value),
                painter = painterResource(id = R.drawable.wheel),
                contentDescription = null,
                contentScale = ContentScale.Fit,
            )
            Image(
                modifier = Modifier.size(52.dp),
                imageVector = Icons.Filled.ArrowDropDown,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.tint(Color.Yellow)
            )
            if (wheelAnim.value == wheelAnim.targetValue) {
                KonfettiView(
                    modifier = Modifier.fillMaxSize(),
                    parties = listOf(
                        Party(
                            speed = 10f,
                            maxSpeed = 30f,
                            damping = 0.8f,
                            spread = 360,
                            colors = listOf(0xfce18a, 0xff726d, 0xf4306d, 0xb48def),
                            position = Position.Relative(0.5, 0.5),
                            emitter = Emitter(duration = 100, TimeUnit.MILLISECONDS).max(100)
                        )
                    ),
                )
            }
        }

        Spacer(modifier = Modifier.height(4.dp))
        MenuButton(
            modifier = Modifier
                .weight(0.25F)
                .padding(horizontal = 32.dp), text = "ROLL",
            style = TextStyle(fontSize = 26.sp)
        ) {
            viewModel.rollWheel()
        }
    }

    LaunchedEffect(viewModel.wheel) {
        if (viewModel.wheel.isRotating) {
            wheelAnim.animateTo(
                targetValue = (-1 * wheelAnim.value) + 90F + viewModel.wheel.degrees,
                animationSpec = repeatable(
                    iterations = 20,
                    animation = tween(200),
                    repeatMode = RepeatMode.Restart
                )
            ).apply {
                when (this.endReason) {
                    AnimationEndReason.BoundReached -> {}
                    AnimationEndReason.Finished -> {
                        wheelAnim.animateTo(-1 * viewModel.wheel.degrees, tween(1500)).apply {
                            when (this.endReason) {
                                AnimationEndReason.BoundReached -> {}
                                AnimationEndReason.Finished -> {
                                    viewModel.stopRolling()
                                }
                            }
                        }

                    }
                }
            }
        }
    }
}