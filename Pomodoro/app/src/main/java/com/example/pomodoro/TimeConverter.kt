package com.example.pomodoro

import javax.microedition.khronos.opengles.GL

object TimeConverter {

    fun millisToMinutes(millis: Long): Int {
        return millis.div(Constants.ONE_MINUTE_IN_MILLIS).toInt()
    }

    fun minutesToMillis(minutes: Int): Long {
        return minutes.times(Constants.ONE_MINUTE_IN_MILLIS)
    }

    fun getMillisByTimeOption(timeOption: TimeOption): Long {
        return when(timeOption) {
            TimeOption.Focus -> this.minutesToMillis(Globals.focusLengthInMinutes)
            TimeOption.LongBreak -> this.minutesToMillis(Globals.longBreakLengthInMinutes)
            TimeOption.ShortBreak -> this.minutesToMillis(Globals.shortBreakLengthInMinutes)
        }
    }

    fun getMinutesByTimeOption(timeOption: TimeOption): Int {
        return when(timeOption) {
            TimeOption.Focus -> Globals.focusLengthInMinutes
            TimeOption.LongBreak -> Globals.longBreakLengthInMinutes
            TimeOption.ShortBreak -> Globals.shortBreakLengthInMinutes
        }
    }

    fun currentTimeToString(minutes: Int, seconds: Int): String {
        val m = minutes.toString().padStart(2, '0')
        val s = seconds.toString().padStart(2, '0')
        return "$m\n$s"
    }

    fun currentTimeToString(): String {
        return this.currentTimeToString(Globals.getCurrentMinutes(), Globals.getCurrentSeconds())
    }
}