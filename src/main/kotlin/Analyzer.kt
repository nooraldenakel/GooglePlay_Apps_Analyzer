import model.App
import util.Constant
import util.calculatePercentage

class Analyzer {
    fun findAppDevelopedByGivenCompany(appDataList: List<App>?, companyName: String?): List<App>? =
        if (!companyName.isNullOrBlank())
            appDataList?.filter { app: App -> app.company.contains(companyName.trim(), true) }
        else { null }

    fun findPercentageOfAppsByCategory(appDataList: List<App>?, categoryName: String?): Double? =
        if (!categoryName.isNullOrBlank()) {
            appDataList?.count { count -> count.category.contains(categoryName.trim(), true) }
                ?.calculatePercentage(appDataList.size)}
        else { null }

    fun findOldestApp(appDataList: List<App>?): App? =
        appDataList?.filterNot { app -> app.updated == null }?.minByOrNull { selector -> selector.updated!! }

    //Refactor
    fun findPercentageOfAppRunningOnSpecificAndroid(appDataList: List<App>?, version: Double): Double? =
        if (version >= Constant.MIN_COMPARE_INT) {
            appDataList?.count { count -> count.requiresAndroid != null && count.requiresAndroid == version }
                ?.calculatePercentage(appDataList.size)}
        else { null }

    fun findLargestApps(appDataList: List<App>?, rankSize: Int): List<App>? =
        if (rankSize in Constant.MIN_COMPARE_INT..(appDataList?.size ?: 0)) {
            appDataList?.sortedByDescending { dataSorted -> dataSorted.size }
                ?.toList()
                ?.take(rankSize) }
        else { null }

    fun topAppInstall(appDataList: List<App>?, size: Int): List<App>? =
        if (size in Constant.MIN_COMPARE_INT..(appDataList?.size ?: 0)) {
            appDataList?.sortedByDescending { dataSorted -> dataSorted.installs }
                ?.take(size)
                ?.toList() }
        else { null }

    fun getLargestAppSizeByCompanyName(appDataList: List<App>?,companyName:String?): App? =
        if (!companyName.isNullOrBlank()) {
            val largestApp = appDataList?.filter { app: App ->  app.company.contains(companyName.trim(), true) }
            findLargestApps(largestApp, 1)?.first()}
        else { null }








}