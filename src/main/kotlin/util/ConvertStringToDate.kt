package util

import java.text.SimpleDateFormat
import java.util.*

fun String.convertStringToDate(): Date {
    val dateList = this.split(" ")
    val dateNewFormat =
        if (dateList[1].toInt() < 10) "${dateList[0]}-0${dateList[1]}-${dateList[2]}"
        else "${dateList[0]}-${dateList[1]}-${dateList[2]}"
    return SimpleDateFormat(Constant.DATE_FORMAT).parse(dateNewFormat)
}