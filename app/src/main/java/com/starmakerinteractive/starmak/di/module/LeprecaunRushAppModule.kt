package com.starmakerinteractive.starmak.di.module

import androidx.lifecycle.MutableLiveData
import com.starmakerinteractive.starmak.data.source.remote.LinkSinataoderacoderacice
import com.starmakerinteractive.starmak.utils.web.comstarmakerinteractivestarmak
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LeprecaunRushAppModule {
    @Provides
    @Singleton
    fun proviinataoderacrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("jhfhl://pretofzv.phq/iay/".comstarmakerinteractivestarmak())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provinataoderacrvice(retrofit: Retrofit): LinkSinataoderacoderacice =
        retrofit.create(LinkSinataoderacoderacice::class.java)

    @Provides
    @Singleton
    fun prinataoderacinataoderactaoderacerLiveData(): MutableLiveData<MutableMap<String, Any>> =
        MutableLiveData<MutableMap<String, Any>>()
}