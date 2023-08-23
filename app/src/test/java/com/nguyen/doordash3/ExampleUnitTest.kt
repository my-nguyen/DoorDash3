package com.nguyen.doordash3

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val rxJavaRule = RxJavaRule()

    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun mytest() {
        val viewModel = MainViewModel(Repository(FakeService()))
        viewModel.getStoreFeed(1.0, 2.0)
        assertEquals("test", 2, viewModel.stores.value?.size)
    }
}
