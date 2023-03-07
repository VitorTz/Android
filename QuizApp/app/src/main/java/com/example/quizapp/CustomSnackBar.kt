package com.example.quizapp


import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

object CustomSnackBar {

    fun show(context: AppCompatActivity, view: View, message: String, time: Int = Toast.LENGTH_SHORT) {
        val snack = Snackbar.make(view, message, time)
        snack.setTextColor(context.resources.getColor(R.color.black, context.theme))
        snack.setBackgroundTint(context.resources.getColor(R.color.melon, context.theme))
        snack.show()
    }
}