package com.example.quizapp


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.quizapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityMainBinding.inflate(this.layoutInflater)
        setContentView(this.binding.root)
        this.supportActionBar?.hide()
        this.reset()
    }

    private fun reset() {
        Globals.username = ""
    }

    fun startQuiz(view: View) {
        val username: String = this.binding.usernameInput.text.toString()
        if (this.binding.usernameInput.text?.isEmpty() == true)
            return CustomSnackBar.show(this, view, this.resources.getString(R.string.invalid_username))
        Globals.username = username
        val intent = Intent(this, QuestionsActivity::class.java)
        this.startActivity(intent)
        this.binding.usernameInput.setText("")
    }
}