package com.example.quizapp

import com.example.quizapp.databinding.ActivityQuizResultBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class QuizResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityQuizResultBinding.inflate(this.layoutInflater)
        setContentView(this.binding.root)
        this.supportActionBar?.hide()
        this.showResult()

        this.binding.btnFinish.setOnClickListener {
            this.finish()
        }

    }

    private fun showResult() {
        this.binding.username.text = Globals.username
        val correctAnswers: Int = this.countCorrectAnswers()
        val questionsSize: Int = Constants.questions.size
        val resultString = "Your score is $correctAnswers of $questionsSize"
        this.binding.userScore.text = resultString
    }

    private fun countCorrectAnswers(): Int {
        return Constants.questions.count { it.answered && it.correctAnswer == it.userAnswer }
    }

}