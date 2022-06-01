package com.starmakerinteractive.starmak.data.model.web

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.starmakerinteractive.starmak.data.model.web.CollectinataoderacinkModel.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class CollectinataoderacinkModel(
    @PrimaryKey val iinataoderacd: Int = 1,
    val cainataoderacLink: String
) {
    companion object {
        const val TABLE_NAME = "CollectedLinkModel"
    }
}
