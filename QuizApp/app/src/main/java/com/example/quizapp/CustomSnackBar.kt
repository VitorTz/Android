package com.example.quizapp


import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import android.view.View

object CustomSnackBar {

    fun show(context: AppCompatActivity, view: View, message: String, time: Int = Toast.LENGTH_SHORT) {
        val snack = Snackbar.make(view, message, time)
        snack.setTextColor(context.resources.getColor(R.color.white, context.theme))
        snack.setBackgroundTint(context.resources.getColor(R.color.grey, context.theme))
        snack.show()
    }
}