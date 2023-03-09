package com.example.pomodoro

import android.os.CountDownTimer

class PomodoroCountDown(
    millisInFuture: Long,
    countDownInterval: Long,
    val targetOnTick: (millisUntilFinished: Long) -> Unit,
    val targetOnFinished: () -> Unit
) : CountDownTimer(millisInFuture, countDownInterval) {

    override fun onTick(millisUntilFinished: Long) {
        this.targetOnTick(millisUntilFinished)
    }

    override fun onFinish() {
        this.targetOnFinished()
    }
}