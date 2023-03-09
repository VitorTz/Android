package com.example.pomodorotimer

import android.os.CountDownTimer

class PomodoroCountDown(
    val targetOnTick: (millisToFinished: Long) -> Unit,
    val targetOnFinish: () -> Unit
) : CountDownTimer(
    PomodoroTime.millisToFinished,
    1000L
) {

    override fun onTick(millisUntilFinished: Long) {
        this.targetOnTick(millisUntilFinished)
    }

    override fun onFinish() {
        this.targetOnFinish()
    }
}