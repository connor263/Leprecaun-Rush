package com.starmakerinteractive.starmak.ui.game.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

@Composable
fun SlotBoard(modifier: Modifier = Modifier) {
    val config = LocalConfiguration.current
    val stepWidth = (config.screenWidthDp / 2) / 5
    val stepHeight = config.screenHeightDp /6

    Card(
        modifier = modifier,
        backgroundColor = Color.Black.copy(alpha = 0.5F),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .height((stepHeight * 5).dp)
                    .clipToBounds(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Top
            ) {
                repeat(5) {
                    SlotView(stepHeight = stepHeight.dp, stepWidth = stepWidth.dp, slotId = it + 1)
                }
            }
        }
    }
}