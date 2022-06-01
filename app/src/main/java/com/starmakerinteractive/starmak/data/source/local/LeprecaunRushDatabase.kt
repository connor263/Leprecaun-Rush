package com.starmakerinteractive.starmak.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.starmakerinteractive.starmak.data.dao.GameDao
import com.starmakerinteractive.starmak.data.dao.InataoderacCacheLinkDao
import com.starmakerinteractive.starmak.data.model.web.CollectinataoderacinkModel
import com.starmakerinteractive.starmak.data.model.game.ScoreModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(version = 1, entities = [ScoreModel::class, CollectinataoderacinkModel::class])
abstract class LeprecaunRushDatabase : RoomDatabase() {
    abstract fun getGameDao(): GameDao
    abstract fun getCacheLinkDao(): InataoderacCacheLinkDao

    class Callback @Inject constructor(
        private val database: Provider<LeprecaunRushDatabase>
    ) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            CoroutineScope(SupervisorJob()).launch {
                database.get().getGameDao().insertScore(ScoreModel(1, 0))
            }
        }
    }
}