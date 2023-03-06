package com.example.quizzapp

object Constants {

    val questions: ArrayList<Question> = loadQuestions()

    fun shuffleQuestions() {
        this.questions.shuffle()
    }
    /**
     * Retorna uma lista com todas as perguntas disponíveis
     */
    private fun loadQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()
        val q1 = Question(
            1,
            "De qual país esta bandeira pertence?",
            R.drawable.ic_flag_of_argentina,
            "Panamá",
            "Holanda",
            "Portugal",
            "Argentina",
            3
        )
        val q2 = Question(
            2,
            "De qual país esta bandeira pertence?",
            R.drawable.ic_flag_of_australia,
            "Peru",
            "Uruguai",
            "Canadá",
            "Australia",
            3
        )
        val q3 = Question(
            3,
            "De qual país esta bandeira pertence?",
            R.drawable.ic_flag_of_belgium,
            "India",
            "Madagascar",
            "Belgica",
            "Africa do Sul",
            2
        )
        val q4 = Question(
            4,
            "De qual país esta bandeira pertence?",
            R.drawable.ic_flag_of_brazil,
            "Japão",
            "Brasil",
            "China",
            "Moçambique",
            1
        )
        val q5 = Question(
            5,
            "De qual país esta bandeira pertence?",
            R.drawable.ic_flag_of_denmark,
            "Dinamarca",
            "Polonia",
            "Alemanha",
            "Replublica Tcheca",
            0
        )
        val q6 = Question(
            6,
            "De qual país esta bandeira pertence?",
            R.drawable.ic_flag_of_fiji,
            "Ucrânia",
            "Rússia",
            "Fiji",
            "Estados Unidos",
            2
        )
        val q7 = Question(
            7,
            "De qual país esta bandeira pertence?",
            R.drawable.ic_flag_of_germany,
            "Alemanha",
            "Paquistão",
            "Iraque",
            "Belgica",
            0
        )
        val q8 = Question(
            8,
            "De qual país esta bandeira pertence?",
            R.drawable.ic_flag_of_india,
            "Haiti",
            "Paraguai",
            "Chile",
            "India",
            3
        )
        val q9 = Question(
            9,
            "De qual país esta bandeira pertence?",
            R.drawable.ic_flag_of_kuwait,
            "Kuwai",
            "Egito",
            "Colombia",
            "Camarões",
            0
        )
        val q10 = Question(
            10,
            "De qual país esta bandeira pertence?",
            R.drawable.ic_flag_of_new_zealand,
            "Nova Zelândia",
            "Corea do Sul",
            "Inglaterra",
            "Tailândia",
            0
        )
        questionsList.addAll(listOf(q1, q2, q3, q4, q5, q6, q7, q8, q9, q10))
        return questionsList
    }

}