package com.example.pomodoro

import androidx.lifecycle.ViewModel

class PomodoroViewModel : ViewModel() {

    private var pomodoroCountDown: PomodoroCountDown? = null

    fun startPomodoro(
        targetOnTick: (millisUntilFinished: Long) -> Unit,
        targetOnFinished: () -> Unit
        ) {
        this.pomodoroCountDown = PomodoroCountDown(
            Globals.millisToFinished,
            Constants.ONE_SECOND_IN_MILLIS,
            targetOnTick,
            targetOnFinished
        )
        this.pomodoroCountDown!!.start()
    }

    fun stopPomodoro() {
        this.pomodoroCountDown?.cancel()
    }

}