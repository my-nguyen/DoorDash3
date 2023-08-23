package com.nguyen.doordash3.dagger

import com.nguyen.doordash3.TCApplication
import com.nguyen.doordash3.storefeed.StoreFeedFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        fun appModule(module: AppModule): Builder
        fun build(): AppComponent
    }

    fun inject(app: TCApplication)
    fun inject(storeFeedFragment: StoreFeedFragment)
}
