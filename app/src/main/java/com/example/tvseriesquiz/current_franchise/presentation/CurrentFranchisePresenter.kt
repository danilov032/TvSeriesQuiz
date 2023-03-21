package com.example.tvseriesquiz.current_franchise.presentation

import com.example.tvseriesquiz.current_franchise.data.repositories.CurrentFranchiseRepository
import com.example.tvseriesquiz.current_franchise.domain.Achievement
import com.example.tvseriesquiz.current_franchise.domain.TestFromList
import com.example.tvseriesquiz.franchise.data.repositories.FranchiseRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class CurrentFranchisePresenter @Inject constructor(private val currentFranchiseRepository: CurrentFranchiseRepository): MvpPresenter<CurrentFranchiseView>(){

    private var testDisposable: Disposable? = null

    fun loadTests(id: String) {
        testDisposable = currentFranchiseRepository.getTestsFranchise(id, "en")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe (
                { tests ->
                    val sortTests = tests.filter { it.feature }
                    viewState.updateFranchises(sortTests)
                }, {
                    val t = it
                }
            )


        val achievements = mutableListOf<Achievement>()
        achievements.add(Achievement("", "Убийца Воланда"))
        achievements.add(Achievement("", "Отлисник"))
        achievements.add(Achievement("", "Принц полукровка"))
        achievements.add(Achievement("", "Заказднить Джини"))
        achievements.add(Achievement("", "Бог Слизерина"))
        achievements.add(Achievement("", "Вся сюжетка"))


        viewState.updateAchievements(achievements)
    }

    fun onClickFranchise(test: TestFromList) {
        viewState.showStartTest()
    }

    override fun onDestroy() {
        testDisposable?.dispose()
    }
}