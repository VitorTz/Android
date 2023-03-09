package com.example.pomodorotimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.pomodorotimer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var pomodoroCountDown: PomodoroCountDown? = null
    private var timeOption: TimeOption = TimeOption.Focus
    private var isRunning: Boolean = false

    private val options = listOf<TimeOption>(TimeOption.ShortBreak, TimeOption.Focus, TimeOption.LongBreak)
    private var optionIndex: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityMainBinding.inflate(this.layoutInflater)
        setContentView(this.binding.root)
        this.supportActionBar?.hide()
        this.setUp()

        this.binding.previousOptionBtn.setOnClickListener {
            this.optionIndex = Math.floorMod(this.optionIndex - 1, 3)
            this.resetCountDown(this.options[this.optionIndex])
        }

        this.binding.nextOptionBtn.setOnClickListener {
            this.optionIndex = Math.floorMod(this.optionIndex +1, 3)
            this.resetCountDown(this.options[this.optionIndex])
        }
    }

    private fun setUp() {
        this.resetCountDown(TimeOption.Focus)
        this.updateTimeTextView()
    }

    fun handlePause(view: View) {
        if (!this.isRunning) {
            this.pomodoroCountDown = PomodoroCountDown(
                targetOnTick = { this.countTime(it)},
                targetOnFinish = { this.pomodoroTimerOnFinished() }
            )
            this.pomodoroCountDown!!.start()
            this.isRunning = true
        } else {
            this.pomodoroCountDown?.cancel()
            this.isRunning = false
        }
    }

    fun openConfig(view: View) {

    }

    private fun countTime(millisToFinished: Long) {
        PomodoroTime.decreaseOneSecond(millisToFinished)
        this.updateTimeTextView()
    }

    private fun updateTimeTextView() {
        this.binding.timeTextView.text = PomodoroTime.toString()
    }

    fun resetCountDown(view: View) {
        this.resetCountDown(this.timeOption)
    }

    private fun resetCountDown(timeOption: TimeOption? = null) {
        if (timeOption != null) this.timeOption = timeOption
        this.pomodoroCountDown?.cancel()
        PomodoroTime.reset(this.timeOption)
        this.updateTimeTextView()
        this.isRunning = false
    }

    private fun pomodoroTimerOnFinished() {

    }
}