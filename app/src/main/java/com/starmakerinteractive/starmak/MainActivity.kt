package com.starmakerinteractive.starmak

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.starmakerinteractive.starmak.ui.navigation.LeprecaunRushAppContent
import com.starmakerinteractive.starmak.ui.theme.LeprecaunRushTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LeprecaunRushTheme {
                val navController = rememberNavController()
                val viewModel: MainActivityViewModel = hiltViewModel()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Transparent
                ) {
                    LeprecaunRushAppContent(navController = navController, viewModel)
                }
            }
        }
    }

    fun initApp() {

    }

}
