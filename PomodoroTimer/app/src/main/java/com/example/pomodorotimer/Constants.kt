package com.example.pomodorotimer

object Constants {

    val oneMinuteInMillis = 60000L

    val timeInMillisByTimeOption: Map<TimeOption, Long> = mapOf(
        Pair(TimeOption.Focus, oneMinuteInMillis * 25L),
        Pair(TimeOption.LongBreak, oneMinuteInMillis * 15L),
        Pair(TimeOption.ShortBreak, oneMinuteInMillis * 5L),
    )

}