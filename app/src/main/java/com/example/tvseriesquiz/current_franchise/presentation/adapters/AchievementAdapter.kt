package com.example.tvseriesquiz.current_franchise.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tvseriesquiz.current_franchise.domain.Achievement
import com.example.tvseriesquiz.current_franchise.presentation.holders.AchievementViewHolder
import com.example.tvseriesquiz.databinding.AchievementItemBinding

class AchievementAdapter: RecyclerView.Adapter<AchievementViewHolder>() {

    private val items: MutableList<Achievement> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AchievementViewHolder {
        val itemBinding = AchievementItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AchievementViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: AchievementViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateItems(list: List<Achievement>){
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }
}