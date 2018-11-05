package com.badikirwan.dicoding.footballmatchschedule.utils

import java.text.SimpleDateFormat
import java.util.*

object Utils {

   fun getFormatDate(dateMatch: String?): String {
      val date = dateMatch?.split("-") as List<String>
      val calendar: Calendar = Calendar.getInstance()

      calendar.set(date[0].toInt(), date[1].toInt(), date[2].toInt(), 0, 0, 0)

      val dayFormatter = SimpleDateFormat("EEE", Locale.US)
      val monthFormatter = SimpleDateFormat("MMMM", Locale.US)
      val dateObj = Date(calendar.timeInMillis)

      return "${dayFormatter.format(dateObj)}, ${date[2]} ${monthFormatter.format(dateObj).substring(0, 3)} ${date[0]}"
   }
}