package com.example.tvseriesquiz.franchise.presentation

import com.example.tvseriesquiz.franchise.domain.Franchise
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface FranchisesView : MvpView {
    fun updateFranchises(listFranchises: List<Franchise>)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun openCurrentFranchise(id: String, name: String)
}