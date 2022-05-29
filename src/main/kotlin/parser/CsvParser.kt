package parser

import model.App
import util.Constant
import util.Converter.convertStringToDate
import util.Converter.convertToDouble

class CsvParser {
    fun parse(line: String): App {
        val tokens = line.split(",")
        return App(
            appName = tokens[Constant.ColumIndex.APP_NAME],
            company = tokens[Constant.ColumIndex.COMPANY],
            category = tokens[Constant.ColumIndex.CATEGORY],
            updatedDate = tokens[Constant.ColumIndex.UPDATE_DATE].convertStringToDate(),
            size = tokens[Constant.ColumIndex.SIZE],
            installs = tokens[Constant.ColumIndex.INSTALLS].toLong(),
            requiresAndroid = tokens[Constant.ColumIndex.REQUIRED_ANDROID].convertToDouble(),
        )
    }
}