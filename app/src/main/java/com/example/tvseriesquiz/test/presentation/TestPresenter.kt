package com.example.tvseriesquiz.test.presentation

import com.example.tvseriesquiz.test_parrent.domain.BaseTest
import moxy.MvpPresenter
import javax.inject.Inject

class TestPresenter @Inject constructor(): MvpPresenter<TestViewState>() {

    private var lastAnswer = -1

     fun checkType(date: BaseTest?, type: String?) {
//         viewState.enableBtnComplit(false)
        when(type) {
            "SINGLE_TEXT" -> {
                date as BaseTest.SingleTextTest
                showSingleTextTest(date)
            }
            "SINGLE_IMAGE" -> {
                date as BaseTest.SingleImageTest
                showSingleImageTest(date)
            }
            "NUMERIC" -> {
                date as BaseTest.NumericTest
            }
            "LETTERS" -> {
                date as BaseTest.LettersTest
            }
            "MULTI_TEXT" -> {
                date as BaseTest.MultyTextTest
            }
            "CORRECT_ORDER_TEXT" -> {
                date as BaseTest.CorrectOrderTextTest
            }
            "CORRECT_ORDER_IMAGE" -> {
                date as BaseTest.CorrectOrderImageTest
            }
        }
    }

    private fun showSingleTextTest(date: BaseTest.SingleTextTest) {
        viewState.showSingleTextTest(date)
    }

    fun clickSingleTextVariant(idAnswer: Int) {
        if(lastAnswer == idAnswer) return
        else{
            lastAnswer = idAnswer
            viewState.setChooseStateSingleTextVariants(lastAnswer)
            viewState.enableBtnComplit(true)
        }
    }

    fun clickSingleImageVariant(idAnswer: Int) {
        if(lastAnswer == idAnswer) return
        else{
            lastAnswer = idAnswer
//            viewState.setChooseStateSingleTextVariants(lastAnswer)
            viewState.enableBtnComplit(true)
        }
    }

    private fun showSingleImageTest(date: BaseTest.SingleImageTest) {
        viewState.showSingleImageTest(date)
    }
}