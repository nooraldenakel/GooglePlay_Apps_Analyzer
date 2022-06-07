package datasource.csvdatasource

import model.App
import datasource.IDataSource
import util.Constant
import java.io.File

class CSVDataSource(private var fileName: String = Constant.CSV_FILE_NAME) : IDataSource {
    override fun getAllData(): List<App>? {
        val appList = mutableListOf<App>()
        File(fileName).apply {
            if (this.exists()) {
                this.forEachLine { line ->
                    appList.add(CsvParser.parse(line))
                }
            }
        }
        return appList.distinctBy { app: App -> app.appName to app.company }.ifEmpty { null }
    }
}