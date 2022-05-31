package com.starmakerinteractive.starmak.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.starmakerinteractive.starmak.MainActivity
import com.starmakerinteractive.starmak.MainActivityViewModel

@Composable
fun InitScreen(viewModel: MainActivityViewModel) {
    val activity = LocalContext.current as MainActivity
    var isLoading = remember { viewModel.isLoading.value }

    Surface(modifier = Modifier.fillMaxSize(), color = Color.Black) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (isLoading) {
                CircularProgressIndicator(modifier = Modifier.size(128.dp), color = Color.Black)
            } else {
                AlertDialog(
                    title = { Text("") },
                    text = { Text( "") },
                    onDismissRequest = { activity.initApp() },
                    shape = RoundedCornerShape(16.dp),
                    confirmButton = {
                        TextButton(onClick = { activity.initApp() }) {
                            Text("")
                        }
                    }
                )
            }
        }
    }


    LaunchedEffect(viewModel.isLoading.value) {
        isLoading = viewModel.isLoading.value
    }
}