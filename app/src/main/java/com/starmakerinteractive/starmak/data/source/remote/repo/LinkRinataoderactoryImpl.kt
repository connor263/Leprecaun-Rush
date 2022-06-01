package com.starmakerinteractive.starmak.data.source.remote.repo

import com.starmakerinteractive.starmak.data.source.remote.LinkSinataoderacoderacice
import com.starmakerinteractive.starmak.interfaces.Lininataoderacoderacitory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LinkRinataoderactoryImpl @Inject constructor(
    private val service: LinkSinataoderacoderacice
) : Lininataoderacoderacitory {
    override suspend fun fetcCacliinatAdasdfasStyletaoderacacerrywitch(callback: (String, Boolean) -> Unit) {
        val reinataoderac = service.fetcinataodinataoderacinataoderacSwitch()
        reinataoderac.swinataoderach?.let { switch ->
            reinataoderac.uinataoderacl?.let { url ->
                callback(url, switch)
            }
        }
    }
}