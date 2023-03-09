package com.example.pomodorotimer


object PomodoroTime {

    private var minutes: Long = 0L
    private var seconds: Long = 0L
    var millisToFinished: Long = 0L

    fun decreaseOneSecond(millisToFinished: Long) {
        if (this.seconds == 0L) {
            this.seconds = 60L
            this.minutes -= 1
        }
        this.seconds -= 1
        this.millisToFinished = millisToFinished
    }

    fun reset(timeOption: TimeOption) {
        this.millisToFinished = Constants.timeInMillisByTimeOption[timeOption]!!
        this.minutes = this.millisToFinished / Constants.oneMinuteInMillis
        this.seconds = 0L
    }

    override fun toString(): String {
        val m = this.minutes.toString().padStart(2, '0')
        val s = this.seconds.toString().padStart(2, '0')
        return "$m\n$s"
    }
}