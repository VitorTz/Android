package com.example.pomodoro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.pomodoro.databinding.ActivityMainBinding

const val TAG = "ActivityMainLogger"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val pomodoroViewModel: PomodoroViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityMainBinding.inflate(this.layoutInflater)
        setContentView(this.binding.root)
        this.supportActionBar?.hide()
        this.setUp()

        this.binding.startBtn.setOnClickListener {
            if (!Globals.isRunning) {
                Globals.isRunning = true
                this.pomodoroViewModel.startPomodoro(
                    targetOnTick = { this.pomodoroOnTick(it) },
                    targetOnFinished = { this.pomodoroOnFinished() }
                )
            } else {
                Globals.isRunning = false
                this.pomodoroViewModel.stopPomodoro()
            }
        }
        this.binding.longBreakTextView.setOnClickListener {
            if (Globals.getCurrentTimeOption() != TimeOption.LongBreak) {
                this.setUp(TimeOption.LongBreak)
                this.makeAllBottomsBarsInvisible()
                this.binding.longBreakBottomBar.visibility = View.VISIBLE
            }
        }

        this.binding.shortBreakTextView.setOnClickListener {
            if (Globals.getCurrentTimeOption() != TimeOption.ShortBreak) {
                this.setUp(TimeOption.ShortBreak)
                this.makeAllBottomsBarsInvisible()
                this.binding.shortBreakBottomBar.visibility = View.VISIBLE
            }
        }

        this.binding.pomodoroTextView.setOnClickListener {
            if (Globals.getCurrentTimeOption() != TimeOption.Focus) {
                this.setUp(TimeOption.Focus)
                this.makeAllBottomsBarsInvisible()
                this.binding.pomodoroBottomBar.visibility = View.VISIBLE
            }
        }

        this.binding.resetBtn.setOnClickListener { this.reset() }

        this.binding.settingsBtn.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            this.startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        if (!Globals.isRunning) {
            this.reset()
        }
    }

    private fun setUp(timeOption: TimeOption = TimeOption.Focus) {
        Globals.setCurrentTimeOption(timeOption)
        this.reset()
    }

    private fun reset() {
        this.pomodoroViewModel.stopPomodoro()
        Globals.isRunning = false
        Globals.millisToFinished = TimeConverter.getMillisByTimeOption(Globals.getCurrentTimeOption())
        Globals.setCurrentMinutes(TimeConverter.getMinutesByTimeOption(Globals.getCurrentTimeOption()))
        Globals.setCurrentSeconds(0)
        this.updateTimeTextView()
    }

    private fun pomodoroOnTick(millisUntilFinished: Long) {
        Globals.millisToFinished = millisUntilFinished
        Globals.setCurrentSeconds(Globals.getCurrentSeconds() - 1)
        this.updateTimeTextView()
    }

    private fun pomodoroOnFinished() {

    }

    private fun updateTimeTextView() {
        this.binding.timeTextView.text = TimeConverter.currentTimeToString()
    }

    private fun makeAllBottomsBarsInvisible() {
        this.binding.shortBreakBottomBar.visibility = View.INVISIBLE
        this.binding.longBreakBottomBar.visibility = View.INVISIBLE
        this.binding.pomodoroBottomBar.visibility = View.INVISIBLE
    }

}