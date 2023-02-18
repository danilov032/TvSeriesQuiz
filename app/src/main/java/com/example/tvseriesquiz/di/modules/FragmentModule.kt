package com.example.tvseriesquiz.di.modules

import com.example.tvseriesquiz.current_franchise.presentation.CurrentFranchiseFragment
import com.example.tvseriesquiz.franchise.presentation.FranchisesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun contributeFranchiseFragment(): FranchisesFragment

    @ContributesAndroidInjector
    abstract fun contributeCurrentFranchiseFragment(): CurrentFranchiseFragment
}