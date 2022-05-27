import parser.ParseData
import util.Constant

fun main() {
    ParseData.parseFile(Constant.FILE_NAME)?.let {listData->
        println("App Develop By Google = ${countAppsDevelopByGoogle(appDataList = listData, companyName = "Google")}")
        println("PercentageOfCategory = ${getPercentageOfCategory(appDataList = listData,categoryName = "Medical")}")
        println("The oldestApp = ${findOldestApp(appDataList = listData)}")
        println("Percentage of Apps Running On Android 9 = ${percentageAppsRunningOnAndroid9(appDataList = listData, requiresAndroid = "9 and up")}")
        println("Largest Top Ten Apps = ${theLargestTopTenApps(appDataList = listData, number = 10)}")
        println("Top Ten App Install = ${topTenAppInstall(appDataList = listData, number = 10)}")}
}