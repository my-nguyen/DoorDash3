package com.nguyen.doordash3.storefeed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nguyen.doordash3.databinding.ItemStoreBinding
import com.nguyen.doordash3.network.model.StoreResponse

/**
 * A RecyclerView.Adapter to populate the screen with a store feed.
 */
class StoreFeedAdapter(val stores: List<StoreResponse>): RecyclerView.Adapter<StoreItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreItemViewHolder {
        return StoreItemViewHolder(
            ItemStoreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: StoreItemViewHolder, position: Int) {
        val store = stores[position]
        with(holder.binding) {
            name.text = store.name
            description.text = store.description
        }
    }

    override fun getItemCount() = stores.size
}

/**
 * Holds the view for the Store item.
 */
class StoreItemViewHolder(val binding: ItemStoreBinding) : RecyclerView.ViewHolder(binding.root)
