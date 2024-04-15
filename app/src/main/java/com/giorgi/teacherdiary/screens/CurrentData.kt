package com.giorgi.teacherdiary.screens

import java.util.*

object CurrentData {
    fun getCurrentDate(): Int {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH) + 1 // Adding 1 because January is represented as 0
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        return day + month * 100 + year * 10000  // $day$month$year
    }
}