package com.example.tvseriesquiz.current_franchise.presentation.holders

import androidx.recyclerview.widget.RecyclerView
import com.example.tvseriesquiz.current_franchise.domain.Test
import com.example.tvseriesquiz.databinding.TestListItemBinding

class TestViewHolder (private val itemBinding: TestListItemBinding, private val clickItemListener: (Test) -> Unit): RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(item: Test) {
        itemBinding.nameTest.text = item.name

        itemBinding.root.setOnClickListener {
            clickItemListener(item)
        }
    }
}