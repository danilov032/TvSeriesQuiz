package com.example.tvseriesquiz.di.modules

import com.example.tvseriesquiz.current_franchise.presentation.CurrentFranchiseFragment
import com.example.tvseriesquiz.databinding.FragmentFinishTestBinding
import com.example.tvseriesquiz.finish_test.FinishTestFragment
import com.example.tvseriesquiz.franchise.presentation.FranchisesFragment
import com.example.tvseriesquiz.settings.presentation.SettingsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.example.tvseriesquiz.start_test.presentation.StartTestFragment
import com.example.tvseriesquiz.test.presentation.TestFragment
import com.example.tvseriesquiz.test_parrent.presentation.TestParentFragment

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

    @ContributesAndroidInjector
    abstract fun contributeTestParentFragment(): TestParentFragment

    @ContributesAndroidInjector
    abstract fun contributeTestFragment(): TestFragment

    @ContributesAndroidInjector
    abstract fun contributeFragmentFinishTestBinding(): FinishTestFragment

}