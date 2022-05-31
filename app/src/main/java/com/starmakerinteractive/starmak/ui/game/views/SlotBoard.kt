package com.starmakerinteractive.starmak.ui.game.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SlotBoard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        backgroundColor = Color.Black.copy(alpha = 0.5F),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .height(250.dp)
                    .clipToBounds(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Top
            ) {
                repeat(5) {
                    SlotView(slotId = it+1)
                }
            }
        }
    }
}