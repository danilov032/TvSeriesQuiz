package com.example.tvseriesquiz.franchise.data.repositories

import com.example.tvseriesquiz.franchise.data.api_modeles.FranchiseResponse
import com.example.tvseriesquiz.franchise.data.mappers.toFranchiseModel
import com.example.tvseriesquiz.franchise.data.services.ApiService
import com.example.tvseriesquiz.franchise.domain.Franchise
import io.reactivex.Single
import javax.inject.Inject

class FranchiseRepository @Inject constructor(private val apiService: ApiService) {

    fun getFranchise(): Single<List<Franchise>> =
        apiService.getListFranchises()
            .map(FranchiseResponse::extractValue)
            .map { responseList ->
                responseList.map { response ->
                    response.toFranchiseModel()
                }
            }

}