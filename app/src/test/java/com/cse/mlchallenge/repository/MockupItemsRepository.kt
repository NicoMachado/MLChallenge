package com.cse.mlchallenge.repository

import androidx.lifecycle.MutableLiveData
import com.cse.mlchallenge.data.ResponseML
import com.cse.mlchallenge.utils.Resource

class MockupItemsRepository: IItemsRepository {

    private val result =MutableLiveData<ResponseML>()

    private var shouldReturnNetworkError = false

    fun setShouldReturnNetworkError(value: Boolean) {
        shouldReturnNetworkError = value
    }

    override suspend fun getSearch(search: String): Resource<ResponseML> {
        return if (shouldReturnNetworkError)
            Resource.error("Network Error" )
        else
            Resource.success(result.value)
    }
}