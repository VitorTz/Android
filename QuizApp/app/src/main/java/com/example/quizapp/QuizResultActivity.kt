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
        this.binding.username.text = this.intent.getStringExtra(Constants.USERNAME)
        val correctAnswers: Int = this.intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        val questionsSize: Int = this.intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val resultString = "Your score is $correctAnswers of $questionsSize"
        this.binding.userScore.text = resultString
    }


}