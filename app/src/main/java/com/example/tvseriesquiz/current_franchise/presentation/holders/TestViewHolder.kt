package com.example.tvseriesquiz.current_franchise.presentation.holders

import androidx.recyclerview.widget.RecyclerView
import com.example.tvseriesquiz.current_franchise.domain.TestFromList
import com.example.tvseriesquiz.databinding.TestListItemBinding

class TestViewHolder (private val itemBinding: TestListItemBinding, private val clickItemListener: (TestFromList) -> Unit): RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(item: TestFromList) {
        itemBinding.nameTest.text = item.name

        itemBinding.root.setOnClickListener {
            clickItemListener(item)
        }
    }
}