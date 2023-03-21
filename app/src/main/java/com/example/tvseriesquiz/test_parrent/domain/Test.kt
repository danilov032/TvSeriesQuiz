package com.example.tvseriesquiz.test_parrent.domain

import java.io.Serializable

data class Question(
    val text: String = "",
    val imageUrl: String = ""
)

data class InputFieldSingle(
    val type: String = "",
    val variants: List<Variants> = listOf(),
    val answer: Int = 0
)

data class InputFieldNumeric(
    val type: String = "",
    val variantsArray: List<Int> = listOf(),
    val answer: Int = 0
)

data class InputFieldLetters(
    val type: String = "",
    val variants: List<String> = listOf(),
    val answer: String = ""
)

data class InputFieldOrder(
    val type: String = "",
    val variants: List<Variants> = listOf(),
    val answer: List<Int> = listOf()
)

data class Variants(
    val id: Int = 0,
    val content: String = ""
)

sealed class BaseTest(open val question: Question, val type: String) : Serializable {
    class SingleTextTest(override val question: Question, val inputField: InputFieldSingle) : BaseTest(question, "SINGLE_TEXT")
    class SingleImageTest(override val question: Question, val inputField: InputFieldSingle) : BaseTest(question, "SINGLE_IMAGE")
    class NumericTest(override val question: Question, val inputField: InputFieldNumeric) : BaseTest(question, "NUMERIC")
    class LettersTest(override val question: Question, val inputField: InputFieldLetters) : BaseTest(question, "LETTERS")
    class MultyTextTest(override val question: Question, val inputField: InputFieldOrder) : BaseTest(question, "MULTI_TEXT")
    class CorrectOrderTextTest(override val question: Question, val inputField: InputFieldOrder) : BaseTest(question, "CORRECT_ORDER_TEXT")
    class CorrectOrderImageTest(override val question: Question, val inputField: InputFieldOrder) : BaseTest(question, "CORRECT_ORDER_IMAGE")
    object EmptyResult: BaseTest(Question(), "")
}