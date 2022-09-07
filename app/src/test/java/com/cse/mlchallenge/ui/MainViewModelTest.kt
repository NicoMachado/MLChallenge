package com.cse.mlchallenge.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.cse.mlchallenge.getOrAwaitValueTest
import com.cse.mlchallenge.repository.MockupItemsRepository
import com.cse.mlchallenge.utils.Status
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

import org.junit.Test
import org.junit.rules.TestRule

class MainViewModelTest {
    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MainViewModel
    private lateinit var itemsRepository : MockupItemsRepository

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun setup() {
        Dispatchers.setMain(mainThreadSurrogate)

        itemsRepository = MockupItemsRepository()

        viewModel = MainViewModel(itemsRepository)
    }

    @Test
    fun `fetch post from cloud should return loading`() {
        viewModel.onSearchClicked("Samsung 5g")
        var value = viewModel.responseLiveData.getOrAwaitValueTest()
        assertTrue("Post greater Success", value.status == Status.LOADING)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset the main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }
}