package com.example.tvseriesquiz.test_parrent.domain

enum class OptionsQuestions {
    SINGLE_TEXT { override val type: String = "SINGLE_TEXT" },
    SINGLE_IMAGE { override val type: String = "SINGLE_IMAGE" },
    NUMERIC { override val type: String = "NUMERIC" },
    LETTERS { override val type: String = "LETTERS" },
    MULTI_TEXT { override val type: String = "MULTI_TEXT" },
    CORRECT_ORDER_TEXT { override val type: String = "CORRECT_ORDER_TEXT" },
    CORRECT_ORDER_IMAGE { override val type: String = "CORRECT_ORDER_IMAGE" };

    abstract val type: String
}