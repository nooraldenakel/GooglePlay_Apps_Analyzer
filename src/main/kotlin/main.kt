import repository.csvdatasource.CSVDataSource

fun main() {
    val analyzer = Analyzer()
    CSVDataSource().getAllData().let {listData ->
        println("App Develop By Company are:  ${analyzer.findAppDevelopedByGivenCompany(appDataList = listData, companyName = "Google")?.count()}")
        println("Percentage Of Category is: ${analyzer.findPercentageOfAppsByCategory(appDataList = listData,categoryName = "Medical")} % ")
        println("The Oldest App is: ${analyzer.findOldestApp(appDataList = listData)}")
        println("Percentage of Apps Running On Android 9 are: ${analyzer.findPercentageOfAppRunningOnSpecificAndroid(appDataList = listData, version = 9.0)} %")
        println("Largest Top Ten Apps are: ${analyzer.findLargestApps(appDataList = listData, rankSize  = 10)}")
        println("Top Ten App Install are: ${analyzer.topAppInstall(appDataList = listData, size = 10)}")
        println("Largest App Size Develop By Company is: ${analyzer.getLargestAppSizeByCompanyName(appDataList = listData, companyName  = "Meta Platform")}")
    }
}