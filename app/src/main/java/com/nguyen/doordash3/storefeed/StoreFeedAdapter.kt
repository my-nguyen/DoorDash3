package com.nguyen.doordash3.storefeed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nguyen.doordash3.databinding.ItemStoreBinding

/**
 * A RecyclerView.Adapter to populate the screen with a store feed.
 */
class StoreFeedAdapter: RecyclerView.Adapter<StoreItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreItemViewHolder {
        return StoreItemViewHolder(
            ItemStoreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: StoreItemViewHolder, position: Int) {
        TODO("Not yet implemented")

        with(holder.binding) {
            name.text = TODO("provide store name")
            description.text = TODO("provide store description")
        }
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}

/**
 * Holds the view for the Store item.
 */
class StoreItemViewHolder(val binding: ItemStoreBinding) : RecyclerView.ViewHolder(binding.root)
