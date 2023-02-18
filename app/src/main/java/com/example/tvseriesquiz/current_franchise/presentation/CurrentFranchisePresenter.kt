package com.example.tvseriesquiz.current_franchise.presentation

import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class CurrentFranchisePresenter @Inject constructor(): MvpPresenter<CurrentFranchiseView>(){

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }
}