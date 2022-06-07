package datasource.csvdatasource

import model.App
import util.Constant
import util.convertStringToDate
import util.convertToDouble
import util.convertToMegaByte

object CsvParser {
    fun parse(line: String): App {
        val tokens = line.split(",")
        return App(
            appName = tokens[Constant.CSVColumIndex.APP_NAME],
            company = tokens[Constant.CSVColumIndex.COMPANY],
            category = tokens[Constant.CSVColumIndex.CATEGORY],
            updated = tokens[Constant.CSVColumIndex.UPDATE_DATE].convertStringToDate(),
            size = tokens[Constant.CSVColumIndex.SIZE].convertToMegaByte(),
            installs = tokens[Constant.CSVColumIndex.INSTALLS].toLong(),
            requiresAndroid = tokens[Constant.CSVColumIndex.REQUIRED_ANDROID].convertToDouble(),
        )
    }
}