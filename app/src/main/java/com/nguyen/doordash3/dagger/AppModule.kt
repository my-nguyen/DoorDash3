package com.nguyen.doordash3.dagger

import android.app.Application
import com.nguyen.doordash3.TCApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule constructor(private val application: TCApplication) {
    @Provides
    @Singleton
    fun getApplication(): Application {
        return application
    }
}
