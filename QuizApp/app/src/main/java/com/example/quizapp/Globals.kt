package com.example.quizapp

object Globals {

    var currentQuestionIndex: Int = 0
    set(value) {
        field = Math.floorMod(value, Constants.questions.size)
    }

    var answeredQuestions: Int = 0
}