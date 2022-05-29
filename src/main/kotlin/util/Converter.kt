package util

import java.text.SimpleDateFormat
import java.util.*


object Converter {
    fun calculatePercentage(dividend: Int, divisor: Int): Double =
        if (divisor != 0) {
            String.format("%.1f", 100.0 * dividend.div(divisor.toDouble())).toDouble()
        } else -1.0

    fun String.convertStringToDate(): Date {
        val dateList = this.split(" ")
        val dateNewFormat =
            if (dateList[1].toInt() < 10) "${dateList[0]}-0${dateList[1]}-${dateList[2]}"
            else "${dateList[0]}-${dateList[1]}-${dateList[2]}"
        return SimpleDateFormat(Constant.DATE_FORMAT).parse(dateNewFormat)
    }

    fun String.convertToDouble(): Double? = this.split(" ").first().toDoubleOrNull()
}