package com.example.tvseriesquiz.test_parrent.presentation

import com.example.tvseriesquiz.test_parrent.domain.BaseTest
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface TestParentView: MvpView {
    @StateStrategyType(OneExecutionStateStrategy::class)
    fun openTest(date: BaseTest)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun openFinishFragment()
}