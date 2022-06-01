package com.starmakerinteractive.starmak.data.source.local.repo

import com.starmakerinteractive.starmak.data.dao.InataoderacCacheLinkDao
import com.starmakerinteractive.starmak.data.model.web.CollectinataoderacinkModel
import com.starmakerinteractive.starmak.interfaces.CacliinatAdasdfasStyletaoderacacerry
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CacliinatAdasdfasStyletaoderacacerryImpl @Inject constructor(
    private val inataoderacCacheLinkDao: InataoderacCacheLinkDao
) : CacliinatAdasdfasStyletaoderacacerry {

    override suspend fun savCacliinatAdasdfasStyletaoderacacerrynk(value: String) {
        inataoderacCacheLinkDao.inseinataoderacrtLink(CollectinataoderacinkModel(cainataoderacLink = value))
    }

    override fun getCaCactaoderacacerryink(): Flow<CollectinataoderacinkModel>? {
        return inataoderacCacheLinkDao.getinataoderacCacheLink()
    }
}