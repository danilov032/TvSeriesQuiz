package com.example.tvseriesquiz.franchise.presentation.holders

import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tvseriesquiz.BuildConfig.IMAGE_HOST
import com.example.tvseriesquiz.databinding.FranchiseItemBinding
import com.example.tvseriesquiz.franchise.domain.Franchise

class FranchiseViewHolder (private val itemBinding: FranchiseItemBinding, private val clickItemListener: (Franchise) -> Unit): RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(item: Franchise) {
        itemBinding.nameFranchise.text = item.title

        itemBinding.root.setOnClickListener {
            clickItemListener(item)
        }

        setUrlInGlide(item.imageUrl, itemBinding.imageFranchise)
    }

    private fun setUrlInGlide(content: String, singleImageVariant: ImageView) {
        Glide
            .with(itemView)
            .load(IMAGE_HOST + content)
            .fitCenter()
            .into(singleImageVariant)
    }
}