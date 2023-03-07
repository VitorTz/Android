package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizapp.databinding.ActivityQuizResultBinding

class QuizResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityQuizResultBinding.inflate(this.layoutInflater)
        setContentView(this.binding.root)
        this.supportActionBar?.hide()
        this.binding.username.text = Globals.username
        val correctAnswers = Globals.countCorrectAnswers().toString()
        val questionsSize = Constants.questions.size.toString()
        this.binding.userScore.text = "Your score is ".plus(correctAnswers).plus(" of ").plus(questionsSize)
        this.binding.btnFinish.setOnClickListener {
            this.finish()
        }
    }

}