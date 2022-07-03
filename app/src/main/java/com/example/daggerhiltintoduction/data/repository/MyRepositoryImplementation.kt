package com.example.daggerhiltintoduction.data.repository

import android.util.Log
import com.example.daggerhiltintoduction.data.remote.MyApi
import com.example.daggerhiltintoduction.domain.repository.MyRepository
import com.example.daggerhiltintoduction.model.ProductItem
import retrofit2.Response

class MyRepositoryImplementation(
    private val api : MyApi
): MyRepository {
    override suspend fun doNetworkCal() : Response<List<ProductItem>> {
        return api.doNetworkCall()
    }
}