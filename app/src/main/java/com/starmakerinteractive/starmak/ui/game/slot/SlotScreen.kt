package com.starmakerinteractive.starmak.ui.game.slot

import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.starmakerinteractive.starmak.R
import com.starmakerinteractive.starmak.ui.game.views.BackButton
import com.starmakerinteractive.starmak.ui.game.views.SlotBoard
import com.starmakerinteractive.starmak.ui.navigation.LepreRushNavKeys

@Composable
fun SlotScreen(navController: NavController, viewModel: SlotViewModel) {
    val score = viewModel.score.collectAsState(initial = null)
    val context = LocalContext.current

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
                .weight(0.85F)
                .padding(horizontal = 128.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(0.20F)
                .padding(vertical = 4.dp)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 64.dp),
                backgroundColor = Color.Green.copy(red = 0.8F),
                shape = RoundedCornerShape(16.dp)
            ) {
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Column(
                        modifier = Modifier
                            .weight(0.75f)
                            .padding(horizontal = 16.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            IconButton(onClick = { viewModel.increaseInvestment() }) {
                                Icon(
                                    modifier = Modifier.size(16.dp),
                                    imageVector = Icons.Rounded.Add,
                                    contentDescription = null
                                )
                            }
                            IconButton(onClick = { viewModel.decreaseInvestment() }) {
                                Icon(
                                    modifier = Modifier.size(16.dp),
                                    imageVector = Icons.Rounded.Clear,
                                    contentDescription = null
                                )
                            }
                            TextButton(onClick = { viewModel.maxInvestment() }) {
                                Text("max", fontSize = 12.sp, color = Color.Black)
                            }
                        }
                        Row {
                            Text("Score: ${score.value?.score ?: 0}", fontSize = 14.sp)
                            Spacer(modifier = Modifier.width(16.dp))
                            Text("Investment: ${viewModel.currentInvestment}", fontSize = 14.sp)
                            Spacer(modifier = Modifier.width(16.dp))
                            Text("Last profit: ${viewModel.lastProfit}", fontSize = 14.sp)
                        }
                    }
                    TextButton(
                        modifier = Modifier.weight(0.25f),
                        onClick = {
                            if (viewModel.currentInvestment == 0) {
                                Toast.makeText(context, "Make an investment", Toast.LENGTH_SHORT).show()
                                if (score.value?.score == 0) {
                                    navController.navigate(LepreRushNavKeys.WheelScreen.route)
                                }
                            } else {
                                viewModel.playSlots()
                            }
                        },
                    ) {
                        Text(
                            text = "PLAY",
                            fontSize = 26.sp
                        )
                    }
                }
            }
        }
    }
}