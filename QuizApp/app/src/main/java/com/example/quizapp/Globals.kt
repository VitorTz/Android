package com.example.quizapp

object Globals {

    var currentQuestionIndex: Int = 0
    set(value) {
        field = Math.floorMod(value, Constants.questions.size)
    }

    var username: String = ""

    fun countCorrectAnswers(): Int {
        return Constants.questions.count {
            it.userAnswer != null && it.userAnswer == it.correctAnswer
        }
    }

}