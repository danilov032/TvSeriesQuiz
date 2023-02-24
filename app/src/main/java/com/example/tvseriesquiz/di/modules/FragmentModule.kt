package com.example.tvseriesquiz.di.modules

import com.example.tvseriesquiz.current_franchise.presentation.CurrentFranchiseFragment
import com.example.tvseriesquiz.franchise.presentation.FranchisesFragment
import com.example.tvseriesquiz.settings.presentation.SettingsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector
import start_test.presentation.StartTestFragment

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun contributeFranchiseFragment(): FranchisesFragment

    @ContributesAndroidInjector
    abstract fun contributeCurrentFranchiseFragment(): CurrentFranchiseFragment

    @ContributesAndroidInjector
    abstract fun contributeSettingsFragment(): SettingsFragment

    @ContributesAndroidInjector
    abstract fun contributeStartTestFragment(): StartTestFragment

}