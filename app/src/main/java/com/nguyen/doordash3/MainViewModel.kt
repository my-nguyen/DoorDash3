package com.nguyen.doordash3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nguyen.doordash3.network.model.StoreResponse
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(val repository: Repository): ViewModel() {
    val _stores = MutableLiveData<List<StoreResponse>>()
    val stores: LiveData<List<StoreResponse>> = _stores

    fun getStoreFeed(latitude: Double, longitude: Double) {
        viewModelScope.launch {
            val list = repository.getStoreFeed(latitude, longitude)
            _stores.value = list
        }
    }
}