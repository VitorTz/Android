package com.example.quizzapp

data class Question(
    val id : Int,
    val question: String,
    val image: Int,
    val option1: String,
    val option2: String,
    val option3: String,
    val option4: String,
    val correctAnswer: Int
) {
    val options: List<String> = listOf(
        this.option1,
        this.option2,
        this.option3,
        this.option4
    )

}
