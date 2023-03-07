package com.example.quizapp

class QuestionList {

    fun reset() {
        Globals.currentQuestionIndex = 0
        Constants.questions.forEach {
            it.answered = false
            it.userAnswer = null
        }
    }

    fun isAllQuestionsAnswered(): Boolean {
        return Constants.questions.count { it.answered } == Constants.questions.size
    }

    fun changeCurrentQuestion(delta: Int) {
        do {
            Globals.currentQuestionIndex += delta
        } while (!this.isAllQuestionsAnswered() && this.getCurrentQuestion().answered)
    }

    fun getCurrentQuestion(): Question {
        return Constants.questions[Globals.currentQuestionIndex]
    }

}