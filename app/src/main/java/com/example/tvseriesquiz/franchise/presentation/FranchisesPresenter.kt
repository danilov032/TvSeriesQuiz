package com.example.tvseriesquiz.franchise.presentation

import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class FranchisesPresenter : MvpPresenter<FranchisesView>(){

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    fun ok() {
        viewState.ok()
    }
}
