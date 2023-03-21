package com.example.tvseriesquiz.test_parrent.data.mappers

import com.example.tvseriesquiz.test_parrent.data.api_modeles.InputFieldResponse
import com.example.tvseriesquiz.test_parrent.data.api_modeles.QuestionResponse
import com.example.tvseriesquiz.test_parrent.data.api_modeles.TestResponse
import com.example.tvseriesquiz.test_parrent.data.api_modeles.VariantsResponse
import com.example.tvseriesquiz.test_parrent.domain.*

fun TestResponse.toTestModel(): BaseTest {
    return when(this.inputField?.type) {
        OptionsQuestions.SINGLE_TEXT.type -> {
            BaseTest.SingleTextTest(
                this.question?.toQuestionModel() ?: Question(),
                this.inputField.toInputFieldSingleModel()
            )
        }
        OptionsQuestions.SINGLE_IMAGE.type -> {
            BaseTest.SingleImageTest(
                this.question?.toQuestionModel() ?: Question(),
                this.inputField.toInputFieldSingleModel()
            )
        }
        OptionsQuestions.NUMERIC.type -> {
            BaseTest.NumericTest(
                this.question?.toQuestionModel() ?: Question(),
                this.inputField.toInputFieldNumericModel()
            )
        }
        OptionsQuestions.LETTERS.type -> {
            BaseTest.LettersTest(
                this.question?.toQuestionModel() ?: Question(),
                this.inputField.toInputFieldLettersModel()
            )
        }
        OptionsQuestions.MULTI_TEXT.type -> {
            BaseTest.MultyTextTest(
                this.question?.toQuestionModel() ?: Question(),
                this.inputField.toInputFieldOrderModel()
            )
        }
        OptionsQuestions.CORRECT_ORDER_TEXT.type -> {
            BaseTest.CorrectOrderTextTest(
                this.question?.toQuestionModel() ?: Question(),
                this.inputField.toInputFieldOrderModel()
            )
        }
        OptionsQuestions.CORRECT_ORDER_IMAGE.type -> {
            BaseTest.CorrectOrderImageTest(
                this.question?.toQuestionModel() ?: Question(),
                this.inputField.toInputFieldOrderModel()
            )
        }
        else -> {
            BaseTest.EmptyResult
        }
    }
}


private
fun QuestionResponse.toQuestionModel(): Question =
    Question(
        this.text ?: "",
        this.imageUrl ?: ""
    )

fun InputFieldResponse.toInputFieldSingleModel(): InputFieldSingle =
    InputFieldSingle(
        this.type ?: "",
        this.variants?.map { it.toVariantsModel() } ?: listOf(),
        (this.answer as? Double)?.toInt()?: 0
    )

fun InputFieldResponse.toInputFieldNumericModel(): InputFieldNumeric =
    InputFieldNumeric(
        this.type ?: "",
        this.variantsArray?.map{ (it as? Double)?.toInt()?: 0 } ?: listOf(),
        (this.answer as? Double)?.toInt()?: 0
    )

fun InputFieldResponse.toInputFieldLettersModel(): InputFieldLetters =
    InputFieldLetters(
        this.type ?: "",
        this.variantsArray?.map{ it as? String?: "" } ?: listOf(),
        this.answer as? String?: ""
    )

fun InputFieldResponse.toInputFieldOrderModel(): InputFieldOrder =
    InputFieldOrder(
        this.type ?: "",
        this.variants?.map { it.toVariantsModel() } ?: listOf(),
        (this.answer as List<*>).map { it as? Double }.map { it?.toInt() ?: 0 }
    )

fun VariantsResponse.toVariantsModel(): Variants =
    Variants(
        this.id ?: 0,
        this.content ?: ""
    )