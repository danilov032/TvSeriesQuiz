package com.example.tvseriesquiz.test_parrent.presentation

import com.example.tvseriesquiz.test_parrent.domain.BaseTest
import com.example.tvseriesquiz.test_parrent.data.repositories.TestParentRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class TestParentPresenter @Inject constructor(private val testParentRepository: TestParentRepository): MvpPresenter<TestParentView>() {

    private var currentIndex = 0
    private var tests: List<BaseTest> = listOf()
    private var testsDisposable: Disposable? = null

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        val tests1 = testParentRepository.getTests()

        testsDisposable = testParentRepository.getTests()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe (
                { testsResponse ->
                    tests = testsResponse
                    if(testsResponse.isEmpty()) {

                    } else {
                        pushFragment()
                    }
                }, {
                    val t = it
                }
            )
    }

    fun nextQuestion() {
        currentIndex++
        if(currentIndex == tests.size) {
            viewState.openFinishFragment()
        } else {
            pushFragment()
        }
    }

    private fun pushFragment() {
        viewState.openTest(tests[currentIndex])
    }

    override fun onDestroy() {
        testsDisposable?.dispose()
    }
}