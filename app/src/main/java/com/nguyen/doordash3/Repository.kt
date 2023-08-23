package com.nguyen.doordash3

import com.nguyen.doordash3.network.TPSCoroutineService
import javax.inject.Inject

class Repository @Inject constructor(val service: TPSCoroutineService) {
    suspend fun getStoreFeed(latitude: Double, longitude: Double) = service.getStoreFeed(latitude, longitude)
}