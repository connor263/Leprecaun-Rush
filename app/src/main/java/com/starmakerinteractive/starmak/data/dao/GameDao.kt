package com.starmakerinteractive.starmak.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.starmakerinteractive.starmak.data.model.ScoreModel
import kotlinx.coroutines.flow.Flow

@Dao
interface GameDao {

    @Query("SELECT * FROM ${ScoreModel.TABLE_NAME}")
    fun getScore(): Flow<ScoreModel>

    @Insert
    suspend fun insertScore(scoreModel:ScoreModel)

    @Update
    suspend fun updateScore(scoreModel:ScoreModel)
}