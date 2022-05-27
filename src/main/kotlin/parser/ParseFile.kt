package parser

import model.App
import java.io.File

object ParseData {
    fun parseFile(fileName: String): List<App>? {
        val csvParser = CsvParser()
        val appList = mutableListOf<App>()
        File(fileName).apply { ->
            if (this.exists()) {
                this.forEachLine { line ->
                    appList.add(csvParser.parse(line))
                }
            }
        }
        return if (appList.isNotEmpty()) appList.distinct() else null
    }
}