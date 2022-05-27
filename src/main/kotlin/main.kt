import parser.ParseData
import util.Constant

fun main() {
    println("CountAppsDevelopByGoogle = ${countAppsDevelopByGoogle(appDataList = ParseData.parseFile(Constant.FILE_NAME))}")
    println("PercentageOfCategory = ${getPercentageOfCategory(appDataList = ParseData.parseFile(Constant.FILE_NAME),categoryName = "Medical")}")
    println("The oldestApp = ${findOldestApp(appDataList = ParseData.parseFile(Constant.FILE_NAME))}")
    println("Percentage of Apps Running On Android9 = ${percentageAppsRunningOnAndroid9(appDataList = ParseData.parseFile(Constant.FILE_NAME))}")
    println("Largest Top Ten Apps = ${theLargestTopTenApps(appDataList = ParseData.parseFile(Constant.FILE_NAME), number = 10)}")
    println("Top Ten App Install = ${topTenAppInstall(appDataList = ParseData.parseFile(Constant.FILE_NAME), number = 10)}")
}