package com.example.tvseriesquiz.current_franchise.data.mappers

import com.example.tvseriesquiz.current_franchise.data.api_modeles.TestsFromListResponse
import com.example.tvseriesquiz.current_franchise.domain.TestFromList

fun TestsFromListResponse.Value.toTestFromListModel(): TestFromList =
    TestFromList(
        this.id ?: "",
        this.title ?: "",
        this.imageUrl ?: "",
        this.feature ?: false
    )