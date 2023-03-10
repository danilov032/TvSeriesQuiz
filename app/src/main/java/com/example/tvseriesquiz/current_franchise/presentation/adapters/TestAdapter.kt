package com.example.tvseriesquiz.current_franchise.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tvseriesquiz.current_franchise.domain.Test
import com.example.tvseriesquiz.current_franchise.presentation.holders.TestViewHolder
import com.example.tvseriesquiz.databinding.TestListItemBinding

class TestAdapter (private val clickItemListener: (Test) -> Unit): RecyclerView.Adapter<TestViewHolder>() {

    private val items: MutableList<Test> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        val itemBinding = TestListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TestViewHolder(itemBinding, clickItemListener)
    }

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateItems(list: List<Test>){
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }
}