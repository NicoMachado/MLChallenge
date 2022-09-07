package com.cse.mlchallenge.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://api.mercadolibre.com/sites/MLA/"
    // Create interceptor y set LOG Level
    private val logging = HttpLoggingInterceptor()

    // Bind interceptor with HttpClient
    private val httpClient = OkHttpClient.Builder()


    val api : MercadoLibreApi by lazy {
        logging.level = HttpLoggingInterceptor.Level.BODY
        httpClient.addInterceptor(logging)

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
            .create(MercadoLibreApi::class.java)
    }
}