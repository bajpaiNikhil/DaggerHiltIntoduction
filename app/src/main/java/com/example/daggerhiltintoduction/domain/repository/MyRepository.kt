package com.example.daggerhiltintoduction.domain.repository

import com.example.daggerhiltintoduction.model.ProductItem
import retrofit2.Response

interface MyRepository {
    suspend fun doNetworkCal() : Response<List<ProductItem>>
}