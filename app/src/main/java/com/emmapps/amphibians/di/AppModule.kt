package com.emmapps.amphibians.di

import com.emmapps.amphibians.data.amphibians.AmphibiansDataSource
import com.emmapps.amphibians.data.amphibians.AmphibiansRepository
import com.emmapps.amphibians.data.amphibians.AmphibiansRepositoryImpl
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppModule {
    val amphibiansRepository: AmphibiansRepository
}

class DefaultAppModule : AppModule {
    private val baseUrl = "https://android-kotlin-fun-mars-server.appspot.com/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val amphibiansDataSource: AmphibiansDataSource by lazy {
        retrofit.create(AmphibiansDataSource::class.java)
    }

    override val amphibiansRepository: AmphibiansRepository by lazy {
        AmphibiansRepositoryImpl(amphibiansDataSource)
    }
}