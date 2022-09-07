package com.cse.mlchallenge.repository

import com.cse.mlchallenge.data.ResponseML
import com.cse.mlchallenge.utils.Resource

interface IItemsRepository {
    suspend fun getSearch(search: String): Resource<ResponseML>
}