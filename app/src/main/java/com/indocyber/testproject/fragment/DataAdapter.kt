package com.indocyber.testproject.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.indocyber.common.entity.Response
import com.indocyber.common.entity.ResponseItem
import com.indocyber.testproject.databinding.DataLayoutItemBinding

class DataAdapter() : RecyclerView.Adapter<DataViewHolder>() {
    private val differ = AsyncListDiffer<ResponseItem>(this, itemCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(
            DataLayoutItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val data = differ.currentList[position]
        holder.binding.data = data
        data.thumbnailUrl.let {
            Glide.with(holder.binding.thumbnail).load("$it.png").into(holder.binding.thumbnail)
        }
    }

    fun submitData(data: List<ResponseItem>){
        differ.submitList(data)
    }

    override fun getItemCount(): Int = differ.currentList.size

    companion object {
        val itemCallBack = object : DiffUtil.ItemCallback<ResponseItem>() {
            override fun areItemsTheSame(oldItem: ResponseItem, newItem: ResponseItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ResponseItem, newItem: ResponseItem): Boolean {
                return oldItem == newItem
            }
        }
    }

}

class DataViewHolder(
    val binding: DataLayoutItemBinding
) : RecyclerView.ViewHolder(binding.root)