package com.example.quizzapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizzapp.databinding.ActivityQuizQuestionsBinding

class QuizQuestionsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuizQuestionsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityQuizQuestionsBinding.inflate(this.layoutInflater)
        setContentView(this.binding.root)
    }
}