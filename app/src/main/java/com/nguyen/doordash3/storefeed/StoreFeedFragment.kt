package com.nguyen.doordash3.storefeed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.nguyen.doordash3.R
import com.nguyen.doordash3.TCApplication
import com.nguyen.doordash3.databinding.FragmentStoreFeedBinding

/**
 * Displays the list of Stores with its title, description and the cover image to the user.
 */
class StoreFeedFragment : Fragment() {
    companion object {
        const val TAG = "StoreFeedFragment"
    }
    private lateinit var storeFeedAdapter: StoreFeedAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        TCApplication.getAppComponent().inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        storeFeedAdapter = StoreFeedAdapter()
        val binding = FragmentStoreFeedBinding.bind(view)
        binding.apply {
            swipeContainer.isEnabled = false
            storesView.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(activity)
                // TODO uncomment the line below whe Adapter is implemented
                // adapter = storeFeedAdapter
            }
        }
    }
}
