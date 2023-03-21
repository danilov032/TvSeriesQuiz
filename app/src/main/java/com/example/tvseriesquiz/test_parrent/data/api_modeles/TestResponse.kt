package com.example.tvseriesquiz.test_parrent.data.api_modeles

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TestResponse(
    @SerializedName("question")
    @Expose
    val question: QuestionResponse? = null,

    @SerializedName("inputField")
    @Expose
    val inputField: InputFieldResponse? = null
)

class QuestionResponse(
    @SerializedName("text")
    @Expose
    val text: String? = null,

    @SerializedName("imageUrl")
    @Expose
    val imageUrl: String? = null
)

class InputFieldResponse(
    @SerializedName("type")
    @Expose
    val type: String? = null,

    @SerializedName("variants")
    @Expose
    val variants: List<VariantsResponse>? = null,

    @SerializedName("variantsArray")
    @Expose
    val variantsArray: List<Any>? = null,

    @SerializedName("answer")
    @Expose
    val answer: Any? = null
)

class VariantsResponse(
    @SerializedName("id")
    @Expose
    val id: Int? = null,

    @SerializedName("content")
    @Expose
    val content: String? = null
)