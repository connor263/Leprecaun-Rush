package com.starmakerinteractive.starmak.ui.game.slot

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.starmakerinteractive.starmak.R
import com.starmakerinteractive.starmak.ui.game.views.BackButton
import com.starmakerinteractive.starmak.ui.game.views.SlotBoard

@Composable
fun SlotScreen(navController: NavController, viewModel: SlotViewModel) {
    val score = viewModel.score.collectAsState(initial = null)

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
        SlotBoard(
            modifier = Modifier
                .weight(0.75F)
                .padding(horizontal = 128.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(0.25F)
                .padding(vertical = 8.dp)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 64.dp),
                backgroundColor = Color.Green.copy(red = 0.8F),
                shape = RoundedCornerShape(16.dp)
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Column(
                        modifier = Modifier
                            .weight(0.75f)
                            .padding(horizontal = 16.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            IconButton(onClick = { viewModel.increaseBet() }) {
                                Icon(
                                    imageVector = Icons.Rounded.Add,
                                    contentDescription = null
                                )
                            }
                            IconButton(onClick = { viewModel.decreaseBet() }) {
                                Icon(
                                    imageVector = Icons.Rounded.Clear,
                                    contentDescription = null
                                )
                            }
                            TextButton(onClick = { viewModel.maxBet() }) {
                                Text("max", fontSize = 16.sp, color = Color.Black)
                            }
                        }
                        Row {
                            Text("Score: ${score.value?.score ?: 0}", fontSize = 16.sp)
                            Spacer(modifier = Modifier.width(16.dp))
                            Text("Bet: ${viewModel.currentBet}", fontSize = 16.sp)
                            Spacer(modifier = Modifier.width(16.dp))
                            Text("Last win: ${viewModel.lastWin}", fontSize = 16.sp)
                        }
                    }
                    TextButton(
                        modifier = Modifier.weight(0.25f),
                        onClick = { viewModel.rollSlots() },
                    ) {
                        Text(
                            text = "ROLL",
                            fontSize = 26.sp
                        )
                    }
                }
            }
        }
    }
}