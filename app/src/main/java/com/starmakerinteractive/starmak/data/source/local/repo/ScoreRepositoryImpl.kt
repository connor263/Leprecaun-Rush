package com.starmakerinteractive.starmak.data.source.local.repo

import com.starmakerinteractive.starmak.data.dao.GameDao
import com.starmakerinteractive.starmak.data.model.ScoreModel
import com.starmakerinteractive.starmak.interfaces.ScoreRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ScoreRepositoryImpl @Inject constructor(private val gameDao: GameDao) : ScoreRepository {
    override fun getScore(): Flow<ScoreModel> {
        return gameDao.getScore()
    }

    override suspend fun updateScore(value: ScoreModel) {
        gameDao.updateScore(value)
    }

}