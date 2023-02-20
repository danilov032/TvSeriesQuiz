package com.example.tvseriesquiz.franchise.data.services

import com.example.tvseriesquiz.franchise.data.api_modeles.FranchiseResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("franchise/getAll")
    fun getListFranchises(@Query("location") location: String = "en"): Single<FranchiseResponse>
}