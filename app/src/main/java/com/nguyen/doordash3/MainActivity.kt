package com.nguyen.doordash3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nguyen.doordash3.storefeed.StoreFeedFragment

/**
 * The initial Activity for the app.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val storeFeedFragment = StoreFeedFragment()
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.container, storeFeedFragment,
                StoreFeedFragment.TAG
            )
            .commit()
    }
}