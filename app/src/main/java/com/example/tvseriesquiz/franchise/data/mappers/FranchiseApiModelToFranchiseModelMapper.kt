package com.example.tvseriesquiz.franchise.data.mappers

import com.example.tvseriesquiz.franchise.data.api_modeles.FranchiseResponse
import com.example.tvseriesquiz.franchise.domain.Franchise

fun FranchiseResponse.Value.toFranchiseModel(): Franchise =
    Franchise(
        this.id ?: "",
        this.title ?: "",
        this.imageUrl ?: "",
        this.feature ?: false
    )