package repository.csvdatasource

import model.App
import util.Constant
import util.convertStringToDate
import util.convertToDouble
import util.convertToMegaByte

object CsvParser {
    fun parse(line: String): App {
        val tokens = line.split(",")
        return App(
            appName = tokens[Constant.ColumIndex.APP_NAME],
            company = tokens[Constant.ColumIndex.COMPANY],
            category = tokens[Constant.ColumIndex.CATEGORY],
            updated = tokens[Constant.ColumIndex.UPDATE_DATE].convertStringToDate(),
            size = tokens[Constant.ColumIndex.SIZE].convertToMegaByte(),
            installs = tokens[Constant.ColumIndex.INSTALLS].toLong(),
            requiresAndroid = tokens[Constant.ColumIndex.REQUIRED_ANDROID].convertToDouble(),
        )
    }
}