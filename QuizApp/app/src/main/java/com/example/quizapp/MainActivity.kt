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
    }

    fun startQuiz(view: View) {
        val username: String = this.binding.usernameInput.text.toString()
        if (username.isEmpty())
            return CustomSnackBar.show(this, view, this.resources.getString(R.string.invalid_username))

        val intent = Intent(this, QuestionsActivity::class.java)
        intent.putExtra(Constants.USERNAME, username)
        this.startActivity(intent)
        this.binding.usernameInput.setText("")
    }
}