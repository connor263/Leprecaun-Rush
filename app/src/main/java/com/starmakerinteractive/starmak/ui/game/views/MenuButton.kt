package com.starmakerinteractive.starmak.ui.game.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MenuButton(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle = TextStyle(fontSize = 32.sp),
    action: () -> Unit,
) {
    TextButton(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp, vertical = 16.dp),
        onClick = { action() },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green.copy(red = 0.8F)),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(2.dp, color = Color.Green.copy(red = 0.2F))
    ) {
        Text(text, style = style)
    }
}