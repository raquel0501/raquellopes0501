package com.example.myapplication2
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication2.data.model.Breeds

class BreedsAdapter : ListAdapter<Breeds, BreedsAdapter.BreedsViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return BreedsViewHolder(inflater.inflate(R.layout.item_breeds, parent, false))
    }

    override fun onBindViewHolder(holder: BreedsViewHolder, position: Int) {
        val breed = getItem(position)
        holder.breed.text = breed!!.name
    }

    private class DiffCallback : DiffUtil.ItemCallback<Breeds>() {

        override fun areItemsTheSame(oldItem: Breeds, newItem: Breeds) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Breeds, newItem: Breeds) =
            oldItem == newItem
    }

    inner class BreedsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val breed = itemView.findViewById(R.id.tv_breed) as TextView
    }
}

