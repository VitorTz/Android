package com.example.quizapp

object Globals {

    var currentQuestionIndex: Int = 0
    set(value) {
        field = Math.floorMod(value, Constants.questions.size)
    }

    var username: String = ""
    var answeredQuestions: Int = 0

}