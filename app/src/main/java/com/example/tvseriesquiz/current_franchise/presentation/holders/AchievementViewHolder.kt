package com.example.tvseriesquiz.current_franchise.presentation.holders

import androidx.recyclerview.widget.RecyclerView
import com.example.tvseriesquiz.current_franchise.domain.Achievement
import com.example.tvseriesquiz.databinding.AchievementItemBinding

class AchievementViewHolder(private val itemBinding: AchievementItemBinding): RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(item: Achievement) {
        itemBinding.nameAchievement.text = item.name
    }
}