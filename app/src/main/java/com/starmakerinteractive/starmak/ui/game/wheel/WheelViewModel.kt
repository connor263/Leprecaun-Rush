package com.starmakerinteractive.starmak.ui.game.wheel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.starmakerinteractive.starmak.data.model.game.ScoreModel
import com.starmakerinteractive.starmak.data.model.game.WheelModel
import com.starmakerinteractive.starmak.data.source.local.repo.ScoreRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class WheelViewModel @Inject constructor(
    private val scoreRepositoryImpl: ScoreRepositoryImpl
) : ViewModel() {
    val scoreModel = scoreRepositoryImpl.getScore()
    var wheel by mutableStateOf(WheelModel())

    fun rollWheel() {
        if (!wheel.isRotating) {
            wheel = WheelModel(Random.nextInt(0, 360).toFloat(), isRotating = true)
        }
    }

    fun stopRolling() = viewModelScope.launch {
        scoreRepositoryImpl.updateScore(ScoreModel(score = processNewScore()))
        wheel = WheelModel(isRotating = false)
    }

    private suspend fun processNewScore(): Int {
        return when (wheel.degrees) {
            in 0F..22.5F -> 50
            in 22.6F..45F -> 100
            in 45.1F..67.6F -> 150
            in 67.7F..90F -> 200
            in 90.1F..112.5F -> 250
            in 112.6F..135F -> 300
            in 135.1F..157.6F -> 350
            in 157.7F..180F -> 400

            in 180.1F..202.6F -> 450
            in 202.7F..225.2F -> 500
            in 225.3F..247.8F -> 550
            in 247.9F..270F -> 600
            in 270.1F..292.6F -> 650
            in 292.7F..315.2F -> 700
            in 315.3F..337.8F -> 750
            in 337.9F..360F -> 800
            else -> 0
        } + scoreModel.first().score
    }
}