package com.example.tvseriesquiz.current_franchise.data.repositories

import com.example.tvseriesquiz.current_franchise.data.api_modeles.TestsFromListResponse
import com.example.tvseriesquiz.current_franchise.data.mappers.toTestFromListModel
import com.example.tvseriesquiz.current_franchise.domain.TestFromList
import com.example.tvseriesquiz.franchise.data.services.ApiService
import io.reactivex.Single
import javax.inject.Inject

class CurrentFranchiseRepository @Inject constructor(private val apiService: ApiService) {

    fun getTestsFranchise(id: String, location: String): Single<List<TestFromList>> =
        apiService.getCurrentFranchises(id, location)
            .map(TestsFromListResponse::extractValue)
            .map { responseList ->
                responseList.map { response ->
                    response.toTestFromListModel()
                }
            }

}