package com.example.tvseriesquiz.franchise.presentation.holders

import androidx.recyclerview.widget.RecyclerView
import com.example.tvseriesquiz.databinding.FranchiseItemBinding
import com.example.tvseriesquiz.franchise.domain.Franchise

class FranchiseViewHolder (private val itemBinding: FranchiseItemBinding, private val clickItemListener: (Franchise) -> Unit): RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(item: Franchise) {
        itemBinding.nameFranchise.text = item.title

        itemBinding.root.setOnClickListener {
            clickItemListener(item)
        }
    }
}