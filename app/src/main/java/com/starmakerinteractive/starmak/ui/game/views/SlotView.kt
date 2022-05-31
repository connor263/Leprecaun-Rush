package com.starmakerinteractive.starmak.ui.game.views

import android.util.Log
import android.widget.Toast
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.starmakerinteractive.starmak.ui.game.slot.SlotViewModel
import com.starmakerinteractive.starmak.utils.game.SLOT_ANIMATION_DURATION
import com.starmakerinteractive.starmak.utils.game.enums.SlotScrollState
import com.starmakerinteractive.starmak.utils.game.randomSlots
import kotlinx.coroutines.delay
import nl.dionsegijn.konfetti.compose.KonfettiView
import nl.dionsegijn.konfetti.core.Party
import nl.dionsegijn.konfetti.core.Position
import nl.dionsegijn.konfetti.core.emitter.Emitter
import java.util.concurrent.TimeUnit

@Composable
fun SlotView(
    modifier: Modifier = Modifier,
    slotId: Int,
) {
    val viewModel: SlotViewModel = viewModel()
    val context = LocalContext.current
    var currentState by remember { mutableStateOf(SlotScrollState.IDLE) }
    val transition = updateTransition(targetState = currentState, label = "")

    var slotImage1 by remember { mutableStateOf(randomSlots) }
    var slotImage2 by remember { mutableStateOf(randomSlots) }
    var slotImage3 by remember { mutableStateOf(randomSlots) }
    var slotImage4 by remember { mutableStateOf(randomSlots) }
    var slotImage5 by remember { mutableStateOf(randomSlots) }
    var nextSlotImage by remember { mutableStateOf(randomSlots) }

    val numberAnim by transition.animateDp(
        label = "",
        transitionSpec = {
            when {
                SlotScrollState.IDLE isTransitioningTo SlotScrollState.SCROLL -> tween(
                    SLOT_ANIMATION_DURATION
                )
                else -> snap()
            }
        }) { state ->
        when (state) {
            SlotScrollState.IDLE -> 0.dp
            SlotScrollState.SCROLL -> 50.dp
        }
    }

    Box(
        modifier = modifier.size(50.dp, 200.dp)
    ) {
        Crossfade(currentState, animationSpec = snap()) { state ->
            state
            Image(
                modifier = Modifier
                    .offset(y = 0.dp - numberAnim)
                    .size(50.dp)
                    .background(
                        if (slotImage1.isMatch) {
                            Color.Yellow.copy(alpha = 0.7F)
                        } else {
                            Color.Transparent
                        }
                    ),
                painter = painterResource(
                    slotImage1.drawableRes
                ),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
            Image(
                modifier = Modifier
                    .offset(y = 50.dp - numberAnim)
                    .size(50.dp)
                    .background(
                        if (slotImage2.isMatch) {
                            Color.Yellow.copy(alpha = 0.7F)
                        } else {
                            Color.Transparent
                        }
                    ),
                painter = painterResource(
                    slotImage2.drawableRes

                ),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
            Image(
                modifier = Modifier
                    .offset(y = 100.dp - numberAnim)
                    .size(50.dp)
                    .background(
                        if (slotImage3.isMatch) {
                            Color.Yellow.copy(alpha = 0.7F)
                        } else {
                            Color.Transparent
                        }
                    ),
                painter = painterResource(

                    slotImage3.drawableRes

                ),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
            Image(
                modifier = Modifier
                    .offset(y = 150.dp - numberAnim)
                    .size(50.dp)
                    .background(
                        if (slotImage4.isMatch) {
                            Color.Yellow.copy(alpha = 0.7F)
                        } else {
                            Color.Transparent
                        }
                    ),
                painter = painterResource(

                    slotImage4.drawableRes

                ),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
            Image(
                modifier = Modifier
                    .offset(y = 200.dp - numberAnim)
                    .size(50.dp)
                    .background(
                        if (slotImage5.isMatch) {
                            Color.Yellow.copy(alpha = 0.7F)
                        } else {
                            Color.Transparent
                        }
                    ),
                painter = painterResource(

                    slotImage5.drawableRes

                ),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
            Image(
                modifier = Modifier
                    .offset(y = 250.dp - numberAnim)
                    .size(50.dp)
                    .background(
                        if (nextSlotImage.isMatch) {
                            Color.Yellow.copy(alpha = 0.7F)
                        } else {
                            Color.Transparent
                        }
                    ),
                painter = painterResource(id = nextSlotImage.drawableRes),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
            if (slotImage1.isMatch || slotImage2.isMatch || slotImage3.isMatch ||
                slotImage4.isMatch || slotImage5.isMatch || nextSlotImage.isMatch
            ) {
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
    }


    LaunchedEffect(Unit) {
        viewModel.updateSlots(
            slotId,
            listOf(
                slotImage1,
                slotImage2,
                slotImage3,
                slotImage4,
                slotImage5
            ).apply {
                forEachIndexed { index, it ->
                    it.id = index + 1
                    it.key = slotId
                }
            },
            initial = true
        )
    }

    LaunchedEffect(viewModel.isRoll) {
        if (viewModel.isRoll) {
            repeat(30) {
                nextSlotImage = randomSlots
                currentState = SlotScrollState.SCROLL


                slotImage1 = slotImage2
                slotImage2 = slotImage3
                slotImage3 = slotImage4
                slotImage4 = slotImage5
                slotImage5 = nextSlotImage

                slotImage1.apply {
                    id = 1
                    key = slotId
                    isMatch = false
                }
                slotImage2.apply {
                    id = 2
                    key = slotId
                    isMatch = false
                }
                slotImage3.apply {
                    id = 3
                    key = slotId
                    isMatch = false
                }
                slotImage4.apply {
                    id = 4
                    key = slotId
                    isMatch = false
                }
                slotImage5.apply {
                    id = 5
                    key = slotId
                    isMatch = false
                }
                nextSlotImage.apply {
                    id = 0
                    key = slotId
                    isMatch = false
                }

                delay(SLOT_ANIMATION_DURATION.toLong())
            }

            currentState = SlotScrollState.IDLE


            viewModel.updateSlots(
                slotId,
                listOf(
                    slotImage1,
                    slotImage2,
                    slotImage3,
                    slotImage4,
                    slotImage5,
                )
            )
        }
    }
}