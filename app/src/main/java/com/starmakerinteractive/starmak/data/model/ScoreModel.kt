package com.starmakerinteractive.starmak.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.starmakerinteractive.starmak.data.model.ScoreModel.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class ScoreModel(
    @ColumnInfo(name = COLUMN_ID)
    @PrimaryKey val idScore: Int = 1,

    @ColumnInfo(name = COLUMN_SCORE)
    val score: Int
) {
    companion object {
        const val TABLE_NAME = "scoreModel"
        const val COLUMN_ID = "idScore"
        const val COLUMN_SCORE = "score"
    }
}