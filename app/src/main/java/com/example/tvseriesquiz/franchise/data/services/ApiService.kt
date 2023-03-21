package com.example.tvseriesquiz.franchise.data.services

import com.example.tvseriesquiz.current_franchise.data.api_modeles.TestsFromListResponse
import com.example.tvseriesquiz.franchise.data.api_modeles.FranchiseResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("franchise/all")
    fun getListFranchises(@Query("location") location: String = "en"): Single<FranchiseResponse>

    @GET("test/byFranchiseId/{id}")
    fun getCurrentFranchises(@Path("id") id: String, @Query("location") location: String = "en"): Single<TestsFromListResponse>
}