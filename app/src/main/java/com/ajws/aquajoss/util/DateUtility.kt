package com.ajws.aquajoss.util

import android.content.Context
import android.text.format.DateUtils
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Andi on 1/5/2017.
 */

object DateUtility {

    const val tag = "DateUtility"

    val TIME_FORMAT = "h:mm aa"

    //public static final String DATE_TIME_FORMAT = "MMM d, h:mm aa";
    val DATE_FORMAT = "MMM d"
    val DATE_YEAR_FORMAT = "MMM d, yyyy"
    val MONTH_DATE_YEAR_FORMAT = "MM/dd/yyyy"
    val DATE_YEAR_TIME_SERVER_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'"
    val YYYY_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss"
    val MMMM_d_YYYY = "MMMM d, yyyy"
    val WEEKDAY_FORMAT = "EEEE"
    val MMMM_d_YYYY_h_mm_a = "MMMM d, yyyy h:mm aa"
    val MMM_D_YYYY_h_mm_a = "MMM d, yyyy h:mm aa"
    val EEE_d_MMM_YYYY = "EEE, d MMM yyyy"
    val DAY_MONTH_DATE_YEAR_FORMAT = "EEE, MM/dd/yyyy"
    val DATE_MONTH_YEAR_FORMAT = "dd/MM/yyyy"
    val MM_DD_YY = "MM/dd/yy"

    fun isToday(date: Date): Boolean {
        val calA = Calendar.getInstance()
        val calB = Calendar.getInstance()
        calB.time = date

        Lg.d("isToday: calA=$calA, calB=$calB")
        return isSameDay(calA, calB)
    }

    fun isYesterday(date: Date): Boolean {
        val calA = Calendar.getInstance()
        calA.add(Calendar.DAY_OF_YEAR, -1)
        val calB = Calendar.getInstance()
        calB.time = date

        Lg.d("isYesterday: calA=$calA, calB=$calB")
        return isSameDay(calA, calB)
    }

    private fun isSameDay(calA: Calendar, calB: Calendar): Boolean {
        Lg.d("isSameDay: calA.day=${calA.get(Calendar.DAY_OF_YEAR)}, calB.day=${calB.get(Calendar.DAY_OF_YEAR)}")
        return calA.get(Calendar.DAY_OF_YEAR) == calB.get(Calendar.DAY_OF_YEAR)
    }

    fun isToday(time: Long): Boolean =
        DateUtils.isToday(time)

    fun isYesterday(time: Long): Boolean {
        val now = Calendar.getInstance()
        val targetDate = Calendar.getInstance()
        targetDate.timeInMillis = time

        now.add(Calendar.DATE, -1)

        return (now.get(Calendar.YEAR) == targetDate.get(Calendar.YEAR)
                && now.get(Calendar.MONTH) == targetDate.get(Calendar.MONTH)
                && now.get(Calendar.DATE) == targetDate.get(Calendar.DATE))
    }

    fun isLast7days(time: Long): Boolean {
        val now = Calendar.getInstance()
        val targetDate = Calendar.getInstance()
        targetDate.timeInMillis = time

        now.add(Calendar.DATE, -6)

        return (now.get(Calendar.YEAR) <= targetDate.get(Calendar.YEAR)
                && now.get(Calendar.MONTH) <= targetDate.get(Calendar.MONTH)
                && now.get(Calendar.DATE) <= targetDate.get(Calendar.DATE))
    }


    fun getDateOnlyFormattedString(date: Date): String {
        return when {
            isToday(date) -> getTimeOnlyFormattedString(date)
            isYesterday(date) -> "Yesterday"
            else -> dateToCalendarString(date)
        }
    }

    private fun dateToCalendarString(date: Date) =
        SimpleDateFormat(MM_DD_YY, Locale.getDefault()).format(date)


    fun getTimeOnlyFormattedString(date: Date): String {
        val sdf = SimpleDateFormat(TIME_FORMAT, Locale.getDefault())
        sdf.timeZone = TimeZone.getDefault()
        return sdf.format(date)
    }

    fun getFullMonthDateYearString(date: Date): String {
        return getDateYearFormattedString(date, MMMM_d_YYYY)
    }

    @JvmOverloads
    fun getDateYearFormattedString(date: Date, format: String = DATE_YEAR_FORMAT): String {
        val sdf = SimpleDateFormat(format, Locale.getDefault())
        val rz = TimeZone.getDefault()
        sdf.timeZone = rz

        return sdf.format(date)
    }

    fun getCurrentDateTimeFormattedString(isServerFormat: Boolean = false): String {
        val date = Date()
        val format = if (isServerFormat) DATE_YEAR_TIME_SERVER_FORMAT else YYYY_MM_dd_HH_mm_ss
        val sdf = SimpleDateFormat(format, Locale.getDefault())
        sdf.timeZone = TimeZone.getDefault()
        return sdf.format(date)
    }

    fun getDateTimeFormattedString(date: Date, isServerFormat: Boolean = false): String {
        val format = if (isServerFormat) DATE_YEAR_TIME_SERVER_FORMAT else YYYY_MM_dd_HH_mm_ss
        val sdf = SimpleDateFormat(format, Locale.getDefault())
        sdf.timeZone = TimeZone.getDefault()
        return sdf.format(date)
    }

    fun getDateFromDateTimeString(date: String): Date? {

        var result: Date? = null
        val sdf = SimpleDateFormat(YYYY_MM_dd_HH_mm_ss, Locale.getDefault())
        sdf.timeZone = TimeZone.getDefault()

        try {
            result = sdf.parse(date)
        } catch (ignored: ParseException) {
        }

        return result
    }

    fun getDateFromString(dateAsString: String): Date? {
        var result: Date? = null
        val dateFormat = SimpleDateFormat(DATE_YEAR_TIME_SERVER_FORMAT, Locale.getDefault())
        dateFormat.timeZone = TimeZone.getDefault()
        try {
            result = dateFormat.parse(dateAsString)
        } catch (ignored: ParseException) {
        }

        return result
    }

    fun getTimeOnlyStringFromServerDate(serverDate: String): String? {
        val date = getDateFromString(serverDate) ?: return null
        return getTimeOnlyFormattedString(date)
    }

    fun getDateYearOnlyStringFromServerDate(serverDate: String): String? {
        val date = getDateFromString(serverDate) ?: return null
        return getDateYearFormattedString(date)
    }

    fun stringWithMillisecondsEpochAndTimeZone(): String {
        val ms = System.currentTimeMillis()
        val timezone = "-0700"
        return "/Date($ms$timezone)/"
    }

    fun compareDateString(aspNetDateStr1: String?, aspNetDateStr2: String?): String? {
        try {
            return if (aspNetDateStr1.isNullOrEmpty() || aspNetDateStr1.isNullOrBlank())
                aspNetDateStr2
            else if (!aspNetDateStr2.isNullOrEmpty() && !aspNetDateStr2.isNullOrBlank()) {
                val tempDate = Regex("[^0-9]").replace(aspNetDateStr1, "").substring(0, 13)
                val tempDate1 = Regex("[^0-9]").replace(aspNetDateStr2, "").substring(0, 13)
                val date = Date(java.lang.Long.parseLong("" + tempDate))
                val date1 = Date(java.lang.Long.parseLong("" + tempDate1))
                if (date1 > date)
                    aspNetDateStr2
                else
                    aspNetDateStr1
            } else
                null
        } catch (e: Exception) {
            Lg.e("compareDateString: ${e.localizedMessage}")
        }
        return null
    }

    fun formatDate(date: Date, format: String): String {
        val sdf = SimpleDateFormat(format, Locale.getDefault())
        return sdf.format(date)
    }

    fun formatMillionSecondsToString(durationInMillis: Long): String {
        //long millis = durationInMillis % 1000;
        val second = durationInMillis / 1000 % 60
        val minute = durationInMillis / (1000 * 60) % 60
        val hour = durationInMillis / (1000 * 60 * 60) % 24
        return if (hour == 0L)
            String.format("%02d:%02d", minute, second)
        else
            String.format("%02d:%02d:%02d", hour, minute, second)
    }

    // Convert 12.1 to "12:05"
    fun formatHoursDoubleToHoursMinutesString(hours: Double): String {
        val h = hours.toInt()
        val m = ((hours.toBigDecimal().subtract(h.toBigDecimal()).toDouble()) * 60).toInt()
        return String.format("%01d:%02d", h, m)
    }

    // Convert 1090 to "06:10 PM"
    fun formatMinuteIntToTimeString(minutes: Int, is12HFormat: Boolean = true): String {
        var h = minutes / 60
        val m = minutes % 60

        if (!is12HFormat)
            return String.format("%02d:%02d", h, m)

        val a = if (h < 12) "AM" else "PM"
        if (h > 12)
            h -= 12
        if (h == 0)
            h = 12
        return String.format("%02d:%02d %s", h, m, a)
    }

    //A week is start from Sat to Sun
    fun isDateInCurrentWeek(date: Date): Boolean {
        val currentCalendar: Calendar = Calendar.getInstance()
        val week: Int = currentCalendar.get(Calendar.WEEK_OF_YEAR)
        val year: Int = currentCalendar.get(Calendar.YEAR)
        val targetCalendar: Calendar = Calendar.getInstance()
        targetCalendar.time = date
        val targetWeek: Int = targetCalendar.get(Calendar.WEEK_OF_YEAR)
        val targetYear: Int = targetCalendar.get(Calendar.YEAR)
        return week == targetWeek && year == targetYear
    }

    fun currentToUTCDateTime(date: Date): Date {
        return Date(date.time - Calendar.getInstance().timeZone.getOffset(date.time))
    }

    fun utcToCurrentDateTime(date: Date): Date {
        return Date(date.time + Calendar.getInstance().timeZone.getOffset(date.time))
    }
}
