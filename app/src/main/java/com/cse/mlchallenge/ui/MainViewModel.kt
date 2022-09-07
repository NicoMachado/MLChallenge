package com.cse.mlchallenge.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cse.mlchallenge.data.Results
import com.cse.mlchallenge.repository.IItemsRepository
import com.cse.mlchallenge.repository.ItemsRepository
import com.cse.mlchallenge.utils.Resource
import com.cse.mlchallenge.utils.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
     val repo: IItemsRepository
    ) : ViewModel() {

    private val _responseLiveData : MutableLiveData<Resource<List<Results>>> = MutableLiveData()
    val responseLiveData : LiveData<Resource<List<Results>>>
        get() = _responseLiveData

    private val _eventChannel = Channel<MainEvent>()
    val eventChannel = _eventChannel.receiveAsFlow()

    var q:String = ""
    private var isLoading = false
    private var isError = false
    
    fun onSearchClicked(query: String) {
        q = query
        viewModelScope.launch() {
            Log.d(TAG, "before getItems ? : ${isLoading}")
            withContext(viewModelScope.coroutineContext + Dispatchers.Main) {
                getItems(query)
            }
            Log.d(TAG, "after getItems ? : ${isLoading}")
            if (!isLoading && !isError) {
                Log.d(TAG, "after getPlaces : SUCCESS ")
                navigateToItemsFragment()
            }
        }
    }

    private suspend fun getItems(query: String) {
        Log.d(TAG, "getItems: query : $query")
        isError = false

        isLoading = true

        val response = try {
            isLoading = true
            _responseLiveData.postValue(Resource(Status.LOADING, null, null))
            repo.getSearch(query)
        } catch (e: IOException) {
            isLoading = false
            isError = true
            Log.e(TAG, "IOException: ${e.localizedMessage}", )
            _responseLiveData.postValue(Resource(Status.ERROR, null,  "IOException: " + e.localizedMessage))
            return
        } catch (e: HttpException) {
            isLoading = false
            isError = true
            Log.e(TAG, "HttpException: ${e.localizedMessage}", )
            _responseLiveData.postValue(Resource(Status.ERROR, null, "HttpException: "  + e.localizedMessage))
            return
        } finally {
            isLoading = false
        }
        if (response != null) {
            _responseLiveData.postValue(Resource(Status.SUCCESS, response.data!!.results, null))
        }

/*
        if (response.isSuccessful && response.body() != null) {
            _responseLiveData.postValue(Resource(Status.SUCCESS, response.body()?.results, null ))
            Log.d(TAG, "postValue ... getPlaces Success")
            isLoading = false
        }
*/
    }

    fun navigateToItemsFragment() {
        viewModelScope.launch {
            _eventChannel.send(MainEvent.NavigateToItemsFragment)
        }
    }

    sealed class MainEvent {
        companion object NavigateToItemsFragment : MainEvent()
        data class NavigateToDetailsFragment (val results: Results): MainEvent()
    }
    companion object {
        private const val TAG = "MainViewModel"
    }
}


