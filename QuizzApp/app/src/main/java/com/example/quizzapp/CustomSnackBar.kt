package com.example.quizzapp

import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar


class CustomSnackBar() {


    fun show(context: AppCompatActivity, view: View, message: String) {
        val s = Snackbar.make(view, message, Toast.LENGTH_SHORT)
        s.setBackgroundTint(context.resources.getColor(R.color.grey_500, context.theme))
        s.setTextColor(context.resources.getColor(R.color.pink, context.theme))
        s.show()
    }
}