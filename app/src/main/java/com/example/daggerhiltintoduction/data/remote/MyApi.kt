package com.example.daggerhiltintoduction.data.remote

import com.example.daggerhiltintoduction.model.ProductItem
import retrofit2.Response
import retrofit2.http.GET

interface MyApi {
    @GET("/products")
    suspend fun doNetworkCall(): Response<List<ProductItem>>
}