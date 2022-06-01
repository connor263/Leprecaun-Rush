package com.starmakerinteractive.starmak.interfaces

import com.starmakerinteractive.starmak.data.model.game.ScoreModel
import kotlinx.coroutines.flow.Flow

interface ScoreRepository {
    fun getScore(): Flow<ScoreModel>
   suspend fun updateScore(value: ScoreModel)
}