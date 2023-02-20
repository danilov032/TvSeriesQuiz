package com.example.tvseriesquiz.franchise.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tvseriesquiz.databinding.FranchiseItemBinding
import com.example.tvseriesquiz.franchise.domain.Franchise
import com.example.tvseriesquiz.franchise.presentation.holders.FranchiseViewHolder

class FranchiseAdapter (private val clickItemListener: (Franchise) -> Unit): RecyclerView.Adapter<FranchiseViewHolder>() {

    private val items: MutableList<Franchise> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FranchiseViewHolder {
        val itemBinding = FranchiseItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FranchiseViewHolder(itemBinding, clickItemListener)
    }

    override fun onBindViewHolder(holder: FranchiseViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateItems(list: List<Franchise>){
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }
}