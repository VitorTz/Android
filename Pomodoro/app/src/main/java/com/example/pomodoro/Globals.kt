package com.example.pomodoro



object Globals {

    var millisToFinished: Long = 0
    var isRunning = false
    private lateinit var currentTimeOption: TimeOption

    var focusLengthInMinutes: Int = 25
    set(value) {
        field = if (value in 1..89) value else field
    }
    var shortBreakLengthInMinutes: Int = 5
        set(value) {
            field = if (value in 1..89) value else field
        }
    var longBreakLengthInMinutes: Int = 15
        set(value) {
            field = if (value in 1..89) value else field
        }
    var pomodorosUntilBreak: Int = 4
        set(value) {
            field = if (value in 1..89) value else field
        }

    private var currentMinutes: Int = 0
    private var currentSeconds: Int = 0

    fun getCurrentMinutes(): Int {
        return this.currentMinutes
    }

    fun setCurrentMinutes(minutes: Int) {
        if (minutes >= 0)
            this.currentMinutes = minutes
        else
            this.currentMinutes = 0
    }

    fun getCurrentSeconds(): Int {
        return this.currentSeconds
    }

    fun setCurrentSeconds(seconds: Int) {
        if (seconds < 0) {
            this.currentSeconds = 59
            this.currentMinutes -= 1
        } else if (seconds >= 60) {
            this.currentSeconds = 0
            this.currentMinutes += 1
        } else {
            this.currentSeconds = seconds
        }
    }

    fun getCurrentTimeOption(): TimeOption {
        return this.currentTimeOption
    }

    fun setCurrentTimeOption(timeOption: TimeOption) {
        this.currentTimeOption = timeOption
        this.currentMinutes = TimeConverter.getMinutesByTimeOption(timeOption)
        this.currentSeconds = 0
    }

}