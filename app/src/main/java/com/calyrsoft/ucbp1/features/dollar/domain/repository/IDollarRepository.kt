package com.calyrsoft.ucbp1.features.dollar.domain.repository

import com.calyrsoft.ucbp1.features.dollar.domain.model.DollarModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface IDollarRepository {
    suspend fun getDollar(): Flow<DollarModel>{
        return flow{
            emit(DollarModel(
                "6.96",
                "12.6",
                "12.55",
                "12.58"
            ))
        }
    }
}