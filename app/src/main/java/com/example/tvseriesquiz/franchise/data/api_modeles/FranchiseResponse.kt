package com.example.tvseriesquiz.franchise.data.api_modeles

import com.example.tvseriesquiz.BaseResponse
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class FranchiseResponse: BaseResponse<List<FranchiseResponse.Value>>() {
    data class Value(
        @SerializedName("_id")
        @Expose
        val id: String? = null,
        @SerializedName("title")
        @Expose
        val title: String? = null
    )
}