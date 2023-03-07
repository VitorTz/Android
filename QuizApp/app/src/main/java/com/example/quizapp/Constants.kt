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
        val q3 = Question(
            id = 2,
            image = R.drawable.ic_flag_of_belgium,
            "Madagascar",
            "Bélgica",
            "Alemanha",
            "Polônia",
            1
        )
        val q4 = Question(
            id = 3,
            image = R.drawable.ic_flag_of_brazil,
            "Brasil",
            "Uruguai",
            "Espanha",
            "Irlanda",
            0
        )
        val q5 = Question(
            id = 4,
            image = R.drawable.ic_flag_of_denmark,
            "Portugal",
            "França",
            "Russia",
            "Dinamarca",
            3
        )
        val q6 = Question(
            id = 5,
            image = R.drawable.ic_flag_of_fiji,
            "Fiji",
            "Estonia",
            "Cuba",
            "Japão",
            0
        )
        val q7 = Question(
            id = 6,
            image = R.drawable.ic_flag_of_germany,
            "Ucrânia",
            "Alemanha",
            "Rússia",
            "Estados Unidos",
            1
        )
        val q8 = Question(
            id = 7,
            image = R.drawable.ic_flag_of_india,
            "Inglaterra",
            "India",
            "Islândia",
            "Costa do Marfim",
            1
        )
        val q9 = Question(
            id = 8,
            image = R.drawable.ic_flag_of_kuwait,
            "Kuwai",
            "Camarões",
            "Luxemburgo",
            "Polônia",
            0
        )
        val q10 = Question(
            id = 9,
            image = R.drawable.ic_flag_of_new_zealand,
            "Noza Zelândia",
            "Coreia do Sul",
            "Inglaterra",
            "Polônia",
            0
        )
        q.addAll(
            listOf(q1, q2, q3, q4, q5, q6, q7, q8, q9, q10)
        )
        return q
    }


}