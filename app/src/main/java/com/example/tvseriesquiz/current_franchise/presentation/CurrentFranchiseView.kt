package com.example.tvseriesquiz.current_franchise.presentation

import com.example.tvseriesquiz.current_franchise.domain.Achievement
import com.example.tvseriesquiz.current_franchise.domain.TestFromList
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface CurrentFranchiseView : MvpView {
    fun updateFranchises(tests: List<TestFromList>)

    fun updateAchievements(achievements: List<Achievement>)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showStartTest()
}