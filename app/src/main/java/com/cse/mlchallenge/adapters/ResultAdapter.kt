package com.cse.mlchallenge.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cse.mlchallenge.R
import com.cse.mlchallenge.data.Results
import com.cse.mlchallenge.databinding.ItemItemBinding
import java.text.NumberFormat

class ResultAdapter (private val context : Context, private val listener: OnItemClickListener) : RecyclerView.Adapter<ResultAdapter.ResultViewHolder>(){
    val numberFormat: NumberFormat = NumberFormat.getInstance()
    
    inner class ResultViewHolder(val binding: ItemItemBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallBack = object : DiffUtil.ItemCallback<Results>() {
        override fun areItemsTheSame(oldItem: Results, newItem: Results): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Results, newItem: Results): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallBack)
    var results : List<Results>
        get() = differ.currentList
        set(value) { differ.submitList(value)}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        return ResultViewHolder(
            ItemItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        
        
        holder.binding.apply {
            val result = results[position]

            itemName.text = result.title
            itemCategory.text = NumberFormat.getCurrencyInstance().format(result.price)
            itemDisponible.text = NumberFormat.getIntegerInstance().format(result.availableQuantity?:0)

            Glide.with(context)
                .load(result.thumbnail)
                .centerCrop()
                .placeholder(R.drawable.mercado_libre_3)
                .error(R.drawable.ic_baseline_broken_image_24)
                .fallback(R.drawable.ic_image_not_supported_white_24dp)
                .into(itemImage)

            //locationDistance.text = result.distance?.toString()
            root.setOnClickListener {
                Log.d(TAG, "onBindViewHolder: click on ${result.permalink}")
                listener.onItemClick(result)
            }
        }
    }

    override fun getItemCount() = results.size

    interface OnItemClickListener {
        fun onItemClick(result: Results)
    }

    companion object {
        private const val TAG = "ResultAdapter"
    }
}