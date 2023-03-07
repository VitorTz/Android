package com.example.quizapp

object Constants {

    val questions: ArrayList<Question> = loadQuestions()

    private fun loadQuestions(): ArrayList<Question> {
        val q: ArrayList<Question> = ArrayList()

        val q1 = Question(
            id = 0,
            image = R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Portugal",
            "Holanda",
            "Paquistão",
            0
        )
        val q2 = Question(
            id = 1,
            image = R.drawable.ic_flag_of_australia,
            "Polônia",
            "Moçambique",
            "Nova Zelândia",
            "Australia",
            3
        )
        q.addAll(
            listOf(q1, q2)
        )
        return q
    }


}