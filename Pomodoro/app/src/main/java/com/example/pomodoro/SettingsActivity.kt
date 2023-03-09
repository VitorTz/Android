package com.example.pomodoro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.pomodoro.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivitySettingsBinding.inflate(this.layoutInflater)
        setContentView(this.binding.root)
        this.supportActionBar?.hide()
        this.setUp()

        this.binding.closeBtn.setOnClickListener {
            this.finish()
        }
        this.binding.focusLengthDownButton.setOnClickListener {
            Globals.focusLengthInMinutes -= 1
            this.updateTextInNumberPicker(this.binding.focusLengthInput, Globals.focusLengthInMinutes)
        }

        this.binding.focusLengthUpButton.setOnClickListener {
            Globals.focusLengthInMinutes += 1
            this.updateTextInNumberPicker(this.binding.focusLengthInput, Globals.focusLengthInMinutes)
        }

        this.binding.shortBreakLengthDownButton.setOnClickListener {
            Globals.shortBreakLengthInMinutes -= 1
            this.updateTextInNumberPicker(this.binding.shortBreakLengthInput, Globals.shortBreakLengthInMinutes)
        }

        this.binding.shortBreakLengthUpButton.setOnClickListener {
            Globals.shortBreakLengthInMinutes += 1
            this.updateTextInNumberPicker(this.binding.shortBreakLengthInput, Globals.shortBreakLengthInMinutes)
        }

        this.binding.longBreakLengthDownButton.setOnClickListener {
            Globals.longBreakLengthInMinutes -= 1
            this.updateTextInNumberPicker(this.binding.longBreakLengthInput, Globals.longBreakLengthInMinutes)
        }

        this.binding.longBreakLengthUpButton.setOnClickListener {
            Globals.longBreakLengthInMinutes += 1
            this.updateTextInNumberPicker(this.binding.longBreakLengthInput, Globals.longBreakLengthInMinutes)
        }

        this.binding.pomodorosLengthDownButton.setOnClickListener {
            Globals.pomodorosUntilBreak -= 1
            this.updateTextInNumberPicker(this.binding.pomodorosLengthInput, Globals.pomodorosUntilBreak)
        }

        this.binding.pomodorosLengthUpButton.setOnClickListener {
            Globals.pomodorosUntilBreak += 1
            this.updateTextInNumberPicker(this.binding.pomodorosLengthInput, Globals.pomodorosUntilBreak)
        }
    }

    private fun setUp() {
        this.updateTextInNumberPicker(this.binding.focusLengthInput, Globals.focusLengthInMinutes)
        this.updateTextInNumberPicker(this.binding.shortBreakLengthInput, Globals.shortBreakLengthInMinutes)
        this.updateTextInNumberPicker(this.binding.longBreakLengthInput, Globals.longBreakLengthInMinutes)
        this.updateTextInNumberPicker(this.binding.pomodorosLengthInput, Globals.pomodorosUntilBreak)
    }

    private fun updateTextInNumberPicker(textView: TextView, number: Int) {
        textView.text = number.toString().padStart(2, '0')
    }
}