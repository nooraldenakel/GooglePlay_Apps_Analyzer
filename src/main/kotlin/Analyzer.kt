import model.App
import util.Constant
import util.Converter.calculatePercentage
import kotlin.math.pow

class Analyzer {
    fun countAppsDevelopByCompany(appDataList: List<App>, companyName: String): Int =
        appDataList.count { it.company.contains(companyName) }


    fun getPercentageOfCategory(appDataList: List<App>, categoryName: String): Double =
        calculatePercentage(
            appDataList.count { it.category.contains(categoryName.trim(), true) },
            appDataList.size
        )


    fun findOldestApp(appDataList: List<App>): String? =
        appDataList.minByOrNull { it.updatedDate }?.appName

    fun getPercentageAppsRunningOnSpecificVersion(apps: List<App>, version: Double): Double =
      calculatePercentage(apps.count { it.requiresAndroid == version }, apps.size)


    fun theLargestTopApps(appDataList: List<App>, size: Int?): List<String> =
        appDataList.asSequence()
            .filterNot { it.size.contains("Varies with device") }
            .sortedByDescending { it.size.calculateSize() }
            .map { it.appName }
            .take(size ?: 0)
            .toList()


    private fun String.calculateSize(): Double =
        when (this.last()) {
            'G' -> {
                this.removeSuffix(this.last().toString()).toDouble() * Constant.KILO_BYTE.pow(3)
            }
            'M' -> {
                this.removeSuffix(this.last().toString()).toDouble() * Constant.KILO_BYTE.pow(2)
            }
            else -> {
                this.removeSuffix(this.last().toString()).toDouble() * Constant.KILO_BYTE.pow(1)
            }
        }

    fun topAppInstall(appDataList: List<App>, size: Int?): List<String> =
        appDataList.asSequence()
            .sortedByDescending { dataSorted -> dataSorted.installs }
            .map { data -> data.appName }
            .take(size ?: 0)
            .toList()
}