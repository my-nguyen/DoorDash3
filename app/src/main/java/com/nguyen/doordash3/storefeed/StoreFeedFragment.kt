package com.nguyen.doordash3.storefeed

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.nguyen.doordash3.Constants.DEFAULT_LATITUDE
import com.nguyen.doordash3.Constants.DEFAULT_LONGITUDE
import com.nguyen.doordash3.MainViewModel
import com.nguyen.doordash3.R
import com.nguyen.doordash3.TCApplication
import com.nguyen.doordash3.ViewModelFactory
import com.nguyen.doordash3.databinding.FragmentStoreFeedBinding
import com.nguyen.doordash3.network.model.StoreResponse
import javax.inject.Inject

/**
 * Displays the list of Stores with its title, description and the cover image to the user.
 */
class StoreFeedFragment : Fragment() {
    companion object {
        const val TAG = "StoreFeedFragment"
    }
    private lateinit var storeFeedAdapter: StoreFeedAdapter
    @Inject
    lateinit var viewModelFactory: ViewModelFactory<MainViewModel>
    private val viewModel: MainViewModel by lazy {
        viewModelFactory.get<MainViewModel>(requireActivity())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        TCApplication.getAppComponent().inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val stores = mutableListOf<StoreResponse>()
        storeFeedAdapter = StoreFeedAdapter(stores)
        val binding = FragmentStoreFeedBinding.inflate(inflater, container, false)
        binding.apply {
            recycler.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(activity)
                adapter = storeFeedAdapter
            }

            filter.setOnClickListener {
                val list = stores.filter { it.name.contains(text.text) }
                Log.d(TAG, "list size: ${list.size}")
                stores.clear()
                stores.addAll(list)
                storeFeedAdapter.notifyDataSetChanged()
            }
        }

        viewModel.getStoreFeed(DEFAULT_LATITUDE, DEFAULT_LONGITUDE)
        viewModel.stores.observe(viewLifecycleOwner) {
            stores.clear()
            stores.addAll(it)
            Log.d(TAG, "list size: ${it.size}")
            storeFeedAdapter.notifyDataSetChanged()
        }

        return binding.root
    }
}
