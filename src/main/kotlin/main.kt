import parser.ParseData
import util.Constant

fun main() {
    val analyzer = Analyzer()
    ParseData.parseFile(Constant.FILE_NAME)?.let {listData->
        println("App Develop By Google = ${analyzer.countAppsDevelopByCompany(appDataList = listData, companyName = "Google")}")
        println("PercentageOfCategory = ${analyzer.getPercentageOfCategory(appDataList = listData,categoryName = "Medical")}")
        println("The oldestApp = ${analyzer.findOldestApp(appDataList = listData)}")
        println("Percentage of Apps Running On Android 9 = ${analyzer.getPercentageAppsRunningOnSpecificVersion(apps = listData, version = 9.0)}")
        println("Largest Top Ten Apps = ${analyzer.theLargestTopApps(appDataList = listData, size  = 10)}")
        println("Top Ten App Install = ${analyzer.topAppInstall(appDataList = listData, size = 10)}")}
}