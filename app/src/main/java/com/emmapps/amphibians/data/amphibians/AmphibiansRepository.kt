package com.emmapps.amphibians.data.amphibians

import com.emmapps.amphibians.model.Amphibian

interface AmphibiansRepository {
    suspend fun getAmphibians(): List<Amphibian>
}

class AmphibiansRepositoryImpl(
    private val amphibiansDataSource: AmphibiansDataSource
) : AmphibiansRepository {
    override suspend fun getAmphibians(): List<Amphibian> {
        return amphibiansDataSource.getAmphibians()
    }
}