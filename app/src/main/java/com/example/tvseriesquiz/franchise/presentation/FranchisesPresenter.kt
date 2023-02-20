package com.example.tvseriesquiz.franchise.presentation

import com.example.tvseriesquiz.franchise.data.repositories.FranchiseRepository
import com.example.tvseriesquiz.franchise.data.services.ApiService
import com.example.tvseriesquiz.franchise.domain.Franchise
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class FranchisesPresenter @Inject constructor(private val franchiseRepository: FranchiseRepository): MvpPresenter<FranchisesView>(){

    private var franchiseDisposable: Disposable? = null

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        getFranchises()
    }

    private fun getFranchises() {
        franchiseDisposable = franchiseRepository.getFranchise()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe (
                {
                    viewState.updateFranchises(it)
                }, {
                    val t = it
                }
            )
    }

    fun onClickFranchise(franchise: Franchise) {
        viewState.openCurrentFranchise(franchise.id)
    }

    override fun onDestroy() {
        franchiseDisposable?.dispose()
    }
}
