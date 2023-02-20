package com.example.tvseriesquiz.current_franchise.presentation

import com.example.tvseriesquiz.current_franchise.domain.Test
import com.example.tvseriesquiz.franchise.domain.Franchise
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class CurrentFranchisePresenter: MvpPresenter<CurrentFranchiseView>(){

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        loadTests()
    }

    private fun loadTests() {
        val tests = mutableListOf<Test>()
        tests.add(Test(1, "Часть 1: Философский камень"))
        tests.add(Test(2, "Часть 2: Философский камень"))
        tests.add(Test(3, "Часть 3: Философский камень"))
        tests.add(Test(4, "Часть 4: Философский камень"))
        tests.add(Test(5, "Часть 5: Философский камень"))
        tests.add(Test(1, "Часть 6: Философский камень"))
        tests.add(Test(2, "Часть 7: Философский камень"))
        tests.add(Test(3, "Часть 8: Философский камень"))
        tests.add(Test(4, "Часть 9: Философский камень"))
        tests.add(Test(5, "Часть 100: Философский камень"))

        viewState.updateFranchises(tests)
    }

    fun onClickFranchise(test: Test) {

    }
}