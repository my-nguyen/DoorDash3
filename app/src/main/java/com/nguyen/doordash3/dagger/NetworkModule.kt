package com.nguyen.doordash3.dagger

import com.google.gson.GsonBuilder
import com.nguyen.doordash3.Constants
import com.nguyen.doordash3.network.TPSCallService
import com.nguyen.doordash3.network.TPSCoroutineService
import com.nguyen.doordash3.network.TPSRxService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Provides Network communication related instances.
 */
@Module
class NetworkModule {
    @Provides
    fun provideTPSCallService(): TPSCallService {
        val gson = GsonBuilder().create()
        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(Constants.BASE_URL)
            .build()
        return retrofit.create(TPSCallService::class.java)
    }

    @Provides
    fun provideCoroutineTPSService(): TPSCoroutineService {
        val gson = GsonBuilder().create()
        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(Constants.BASE_URL)
            .build()
        return retrofit.create(TPSCoroutineService::class.java)
    }

    @Provides
    fun provideRxTPSService(): TPSRxService {
        val gson = GsonBuilder().create()
        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(Constants.BASE_URL)
            .build()
        return retrofit.create(TPSRxService::class.java)
    }
}
