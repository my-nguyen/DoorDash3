package com.nguyen.doordash3

import com.nguyen.doordash3.network.TPSCoroutineService
import com.nguyen.doordash3.network.model.StoreAddressResponse
import com.nguyen.doordash3.network.model.StoreDetailsResponse
import com.nguyen.doordash3.network.model.StoreResponse

class FakeService : TPSCoroutineService {
    override suspend fun getStoreFeed(latitude: Double, longitude: Double): List<StoreResponse> {
        val store1 = StoreResponse("111", "In-n-Out", "Fast Food", "", "open", "$5")
        val store2 = StoreResponse("222", "McDonald's", "To go food", "", "open", "$3")
        return listOf(store1, store2)
    }

    override suspend fun getStoreDetails(storeId: String): StoreDetailsResponse {
        return StoreDetailsResponse("333", "Burger King", "very fat food", "", "408-555-1212", "20 minutes", "open", 4, listOf("abc", "def"), StoreAddressResponse("1010 Binary Rd, San Jose, CA"))
    }
}