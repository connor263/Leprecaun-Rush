package com.starmakerinteractive.starmak.data.dao

import androidx.room.*
import com.starmakerinteractive.starmak.data.model.web.CollectinataoderacinkModel
import kotlinx.coroutines.flow.Flow

@Dao
interface InataoderacCacheLinkDao {
    @Query("SELECT * FROM ${CollectinataoderacinkModel.TABLE_NAME}")
    fun getinataoderacCacheLink(): Flow<CollectinataoderacinkModel>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inseinataoderacrtLink(value: CollectinataoderacinkModel)
}