package com.example.tvseriesquiz.current_franchise.presentation

import com.example.tvseriesquiz.current_franchise.domain.Achievement
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

        viewState.updateFranchises(tests)


        val achievements = mutableListOf<Achievement>()
        achievements.add(Achievement("", "Убийца Воланда"))
        achievements.add(Achievement("", "Отлисник"))
        achievements.add(Achievement("", "Принц полукровка"))
        achievements.add(Achievement("", "Заказднить Джини"))
        achievements.add(Achievement("", "Бог Слизерина"))
        achievements.add(Achievement("", "Вся сюжетка"))


        viewState.updateAchievements(achievements)
    }

    fun onClickFranchise(test: Test) {
        viewState.showStartTest()
    }
}