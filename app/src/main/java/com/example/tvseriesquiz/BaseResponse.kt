package com.example.tvseriesquiz

import com.example.tvseriesquiz.errors.BadDataResponseException
import com.google.gson.annotations.SerializedName

@XsonTable
open class BaseResponse<out T>(
    @SerializedName(value = "success") val success: Boolean = false,
    @SerializedName(value = "data") open val value: T? = null
) {

    @Throws(BadDataResponseException::class)
    open fun extractValue(): T {
        val value = this.value
        val success = this.success

        if (value == null) throw BadDataResponseException()
        else if (!success) throw BadDataResponseException()

        return value
    }
}

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
annotation class XsonTable(
    val columnArrayName: String = "Columns",
    val dataArrayName: String = "Data"
)