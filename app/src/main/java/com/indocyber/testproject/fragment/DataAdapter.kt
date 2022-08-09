package com.indocyber.testproject.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.indocyber.common.entity.Response
import com.indocyber.common.entity.ResponseItem
import com.indocyber.testproject.databinding.DataLayoutItemBinding

class DataAdapter() : RecyclerView.Adapter<DataViewHolder>() {
    private val differ = AsyncListDiffer<Response>(this, itemCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(
            DataLayoutItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    fun submitData(data: Response){
        differ.submitList(data)
    }

    companion object {
        val itemCallBack = object : DiffUtil.ItemCallback<Response>() {
            override fun areItemsTheSame(oldItem: Response, newItem: Response): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Response, newItem: Response): Boolean {
                return true
            }
        }
    }

}

class DataViewHolder(
    val binding: DataLayoutItemBinding
) : RecyclerView.ViewHolder(binding.root)