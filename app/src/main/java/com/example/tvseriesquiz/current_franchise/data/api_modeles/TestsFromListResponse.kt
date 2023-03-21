package com.example.tvseriesquiz.current_franchise.data.api_modeles

import com.example.tvseriesquiz.BaseResponse
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TestsFromListResponse: BaseResponse<List<TestsFromListResponse.Value>>() {
    data class Value(
        @SerializedName("_id")
        @Expose
        val id: String? = null,
        @SerializedName("title")
        @Expose
        val title: String? = null,
        @SerializedName("imageUrl")
        @Expose
        val imageUrl: String? = null,
        @SerializedName("feature")
        @Expose
        val feature: Boolean? = false
    )
}