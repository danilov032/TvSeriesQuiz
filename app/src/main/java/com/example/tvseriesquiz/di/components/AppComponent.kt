package com.example.tvseriesquiz.di.components

import android.content.Context
import com.example.tvseriesquiz.TvSeriesQuizApp
import com.example.tvseriesquiz.di.modules.ActivityModule
import com.example.tvseriesquiz.di.modules.AppModule
import com.example.tvseriesquiz.di.modules.FragmentModule
import dagger.android.AndroidInjector
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, ActivityModule::class, FragmentModule::class, AppModule::class])
interface AppComponent: AndroidInjector<TvSeriesQuizApp> {

    override fun inject(instance: TvSeriesQuizApp)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun bindContext(context: Context): Builder

        fun build(): AppComponent
    }

}