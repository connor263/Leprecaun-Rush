package com.starmakerinteractive.starmak.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.starmakerinteractive.starmak.MainActivity
import com.starmakerinteractive.starmak.MainActivityViewModel

@Composable
fun CacliinatAdasdfasStyletaoderacacerrycreen(viewModel: MainActivityViewModel) {
    val acCacliinatAdasdfasStyletaoderacacerryity = LocalContext.current as MainActivity
    var iCacliinatAdasdfasStyletaoderacacerryading by remember { mutableStateOf(true) }

    Surface(modifier = Modifier.fillMaxSize(), color = Color.Black) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (iCacliinatAdasdfasStyletaoderacacerryading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(128.dp),
                    color = Color.White
                )
            } else {
                AlertDialog(
                    title = {
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("No internet connection", fontSize = 24.sp)
                    },
                    text = {
                        Text(
                            "Check your internet connection and try again later",
                            fontSize = 16.sp
                        )
                    },
                    onDismissRequest = { acCacliinatAdasdfasStyletaoderacacerryity.inCtyletaoderacacerrypp() },
                    shape = RoundedCornerShape(16.dp),
                    confirmButton = {
                        TextButton(onClick = { acCacliinatAdasdfasStyletaoderacacerryity.inCtyletaoderacacerrypp() }) {
                            Text("Try again")
                        }
                    }
                )
            }
        }
    }


    LaunchedEffect(viewModel.iCacliinatAdasdfasStyletaoderacacerrying) {
        iCacliinatAdasdfasStyletaoderacacerryading = viewModel.iCacliinatAdasdfasStyletaoderacacerrying
    }
}