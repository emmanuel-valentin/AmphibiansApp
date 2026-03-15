package com.emmapps.amphibians.data.amphibians

import com.emmapps.amphibians.model.Amphibian
import retrofit2.http.GET

interface AmphibiansDataSource {
    @GET("amphibians")
    suspend fun getAmphibians(): List<Amphibian>
}