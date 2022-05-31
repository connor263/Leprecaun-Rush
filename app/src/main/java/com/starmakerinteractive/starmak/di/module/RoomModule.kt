package com.starmakerinteractive.starmak.di.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.starmakerinteractive.starmak.data.source.local.LeprecaunRushDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application,callback:LeprecaunRushDatabase.Callback) = Room.databaseBuilder(
        app,
        LeprecaunRushDatabase::class.java,
        "LeprecaunRushDatabase"
    ).addCallback(callback)
        .build()

    @Provides
    @Singleton
    fun provideGameDao(db: LeprecaunRushDatabase) = db.getGameDao()
}