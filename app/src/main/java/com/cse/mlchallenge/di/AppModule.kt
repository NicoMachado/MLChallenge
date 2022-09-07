package com.cse.mlchallenge.di

import android.content.Context
import android.util.Log
import com.cse.mlchallenge.repository.IItemsRepository
import com.cse.mlchallenge.repository.ItemsRepository
import com.cse.mlchallenge.retrofit.MercadoLibreApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesRetrofit(@ApplicationContext context: Context): Retrofit {
        val BASE_URL = "https://api.mercadolibre.com/sites/MLA/"
        Log.d("AppModule", "provideRetrofit: ")

        // Creamos un interceptor y le indicamos el log level a usar
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        // Asociamos el interceptor a las peticiones
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        val okHttpClient = OkHttpClient.Builder()
            //.addInterceptor(HostSelectionInterceptor())
            .addInterceptor(logging)
            .cache(null)
            .build()

        val gson: Gson = GsonBuilder()
            .create()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun providesMercadoLibreApi(retrofit: Retrofit): MercadoLibreApi {
        return retrofit.create(MercadoLibreApi::class.java)
    }

    @Provides
    @Singleton
    fun providesItemsRepository(api: MercadoLibreApi): IItemsRepository = ItemsRepository(api)

} 