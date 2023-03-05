package com.example.quizzapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.quizzapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var customSnackBar: CustomSnackBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityMainBinding.inflate(this.layoutInflater)
        setContentView(this.binding.root)
        this.supportActionBar?.hide()
        this.customSnackBar = CustomSnackBar()
    }

    private fun getUserName(): String {
        return this.binding.usernameInput.text.toString().dropLastWhile { n -> n == ' ' }
    }

    private fun checkUsername(): Boolean {
        if (this.getUserName().isEmpty()) {
            this.customSnackBar.show(
                this,
                this.binding.root,
                this.resources.getString(R.string.usernameEmptyError)
            )
            return false
        }
        return true
    }

    private fun clearUsernameInput() {
        this.binding.usernameInput.setText("")
    }

    fun startGame(view: View) {
        if (this.checkUsername()) {
            val intent = Intent(this, QuizQuestionsActivity::class.java)
            startActivity(intent)
            this.clearUsernameInput()
            // this.finish()  // Fecha a atividade main.
        }
    }
}