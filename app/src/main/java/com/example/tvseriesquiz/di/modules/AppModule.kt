package com.example.tvseriesquiz.di.modules

import androidx.annotation.NonNull
import com.example.tvseriesquiz.BuildConfig
import com.example.tvseriesquiz.current_franchise.presentation.CurrentFranchisePresenter
import com.example.tvseriesquiz.franchise.data.api_modeles.FranchiseResponse
import com.example.tvseriesquiz.franchise.data.repositories.FranchiseRepository
import com.example.tvseriesquiz.franchise.data.services.ApiService
import com.example.tvseriesquiz.franchise.presentation.FranchisesPresenter
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(@NonNull okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(BuildConfig.FIRST_HOST)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun getApi(@NonNull retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    fun provideFranchiseRepository(apiService: ApiService): FranchiseRepository {
        return FranchiseRepository(apiService)
    }

    @Provides
    fun provideFranchisesPresenter(franchiseRepository: FranchiseRepository): FranchisesPresenter {
        return FranchisesPresenter(franchiseRepository)
    }

    @Provides
    fun provideCurrentFranchisePresenter(): CurrentFranchisePresenter {
        return CurrentFranchisePresenter()
    }
}