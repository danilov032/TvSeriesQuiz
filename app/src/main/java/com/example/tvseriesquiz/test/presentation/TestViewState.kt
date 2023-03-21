package com.example.tvseriesquiz.test.presentation

import com.example.tvseriesquiz.test_parrent.domain.BaseTest
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface TestViewState: MvpView {
    fun showSingleTextTest(date: BaseTest.SingleTextTest)

    fun showSingleImageTest(date: BaseTest.SingleImageTest)

    fun enableBtnComplit(enable: Boolean)

    fun setChooseStateSingleTextVariants(indexChoose: Int)

    fun setChooseStateSingleImageVariants(indexChoose: Int)
}