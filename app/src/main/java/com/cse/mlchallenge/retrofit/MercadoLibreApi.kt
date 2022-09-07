package com.cse.mlchallenge.retrofit

import com.cse.mlchallenge.data.ResponseML
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MercadoLibreApi {
    @GET("/sites/MLA/search")
    suspend fun getSearch(@Query("q") query: String): Response<ResponseML>
}