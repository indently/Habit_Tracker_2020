package com.federicocotogno.habittracker2020.logic.utils

import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat

object Calculations {

    //todo: Change it so it returns a string to display to the textView of the habit item
    fun calculateTimeBetweenDates(startDate: String, endDate: String) {

        val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
        val date1 = sdf.parse(startDate)
        val date2 = sdf.parse(endDate)

        val difference = date2.time - date1.time

        val minutes = difference / 60 / 1000
        val hours = difference / 60 / 1000 / 60
        val days = (difference / 60 / 1000 / 60) / 24
        val months = (difference / 60 / 1000 / 60) / 24 / (365 / 12)
        val years = difference / 60 / 1000 / 60 / 24 / 365

        println(
            """
        Minutes: $minutes
        Hours: $hours
        Days: $days
        Months: $months
        Years: $years
    """.trimIndent()
        )
    }

    fun timeStampToDateString(timestamp: Long): String {

        val stamp = Timestamp(timestamp)
        val sdf = SimpleDateFormat("dd/MM/yyyy")
        val date = sdf.format(Date(stamp.time))

        return date.toString()

    }

    fun timeStampToTimeString(timestamp: Long): String {

        val stamp = Timestamp(timestamp)
        val sdf = SimpleDateFormat("HH:mm:ss")
        val time = sdf.format(Date(stamp.time))

        return time.toString()

    }
}