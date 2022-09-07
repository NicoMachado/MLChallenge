package com.cse.mlchallenge.repository

import com.cse.mlchallenge.data.ResponseML
import com.cse.mlchallenge.retrofit.MercadoLibreApi
import com.cse.mlchallenge.utils.Resource
import com.cse.mlchallenge.utils.Status
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ItemsRepository @Inject constructor(
    private val api: MercadoLibreApi
): IItemsRepository {
    override suspend fun getSearch(search: String): Resource<ResponseML> {
        return try {
            val call = api.getSearch(search)
            if (call.isSuccessful && call.body() != null) {
                Resource(Status.SUCCESS, call.body(), null)
            } else {
                Resource(Status.ERROR, null, call.message())
            }
        } catch (e: HttpException) {
            Resource(Status.ERROR, null, e.localizedMessage)
        } catch (e: IOException) {
            Resource(Status.ERROR, null, e.localizedMessage)
        }

    }
}