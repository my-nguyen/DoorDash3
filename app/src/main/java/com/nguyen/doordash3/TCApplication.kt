package com.nguyen.doordash3

import android.app.Application
import com.nguyen.doordash3.dagger.AppComponent
import com.nguyen.doordash3.dagger.AppModule
import com.nguyen.doordash3.dagger.DaggerAppComponent

/**
 * The application class - an entry point into our app where we initialize Dagger.
 */
class TCApplication : Application() {
    companion object {
        private lateinit var appComponent: AppComponent

        fun getAppComponent(): AppComponent {
            return appComponent
        }
    }

    override fun onCreate() {
        super.onCreate()
        initDaggerAppComponent()
    }

    private fun initDaggerAppComponent(): AppComponent {
         appComponent =
               DaggerAppComponent.builder()
                         .appModule(AppModule(this))
                         .build()
        return appComponent
    }
}
