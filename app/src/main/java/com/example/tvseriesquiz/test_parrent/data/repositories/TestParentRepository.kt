package com.example.tvseriesquiz.test_parrent.data.repositories

import android.content.Context
import com.example.tvseriesquiz.franchise.data.services.ApiService
import com.example.tvseriesquiz.test_parrent.data.api_modeles.TestResponse
import com.example.tvseriesquiz.test_parrent.domain.BaseTest
import com.example.tvseriesquiz.test_parrent.data.mappers.toTestModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.Single
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset
import javax.inject.Inject

class TestParentRepository @Inject constructor(private val apiService: ApiService, private val context: Context) {

    var gson = Gson()

    fun getTests(): Single<List<BaseTest>> = Single.just(gson.fromJson<List<TestResponse>?>(loadJSONFromAsset(context), object : TypeToken<List<TestResponse>>() {}.type).map { it.toTestModel() })

    private fun loadJSONFromAsset(context: Context): String? {
        var json: String? = null
        try {
            val from: InputStream = context.assets.open("test.json")
            val size: Int = from.available()
            val buffer = ByteArray(size)
            from.read(buffer)
            from.close()
            json = String(buffer, Charset.defaultCharset())
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
        return json
    }

}