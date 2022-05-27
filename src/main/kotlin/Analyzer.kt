import model.App
import kotlin.math.roundToInt


//Req1 -Find Count Of App Develop by Google.#Nooralden
fun countAppsDevelopByGoogle(appDataList: List<App>): Int? =
    if (appDataList.isNotEmpty())
        appDataList.count { it.company.contains("Google") }
    else null

//Req2 -Find Percentage of Category.#Nada
fun getPercentageOfCategory(appDataList: List<App>, categoryName: String): Double =
    appDataList.count { it.category.contains(categoryName) }
        .div(appDataList.size.toDouble()).times(100)
        .times(100).roundToInt().toDouble() / 100

//Req3 -Find Oldest App.#Nada
fun findOldestApp(appDataList: List<App>): String? =
    if (appDataList.isNotEmpty())
        appDataList.minByOrNull { it.updatedDate }?.appName
    else null

//Req4 -Find Percentage Of App Running On Android 9.#Rash
fun percentageAppsRunningOnAndroid9(appDataList: List<App>): Int? =
    if (appDataList.isNotEmpty())
        appDataList.filter { it.requiresAndroid.contains("9 and up") }
            .map { String.format("%.1f", 100.0 * it.requiresAndroid.count() / appDataList.size) }.count()
    else null


//Req5 -Find The Largest Top Ten Apps.#Nooralden
fun theLargestTopTenApps(appDataList: List<App>, number: Int): List<String?>? =
    if (appDataList.isNotEmpty())
        appDataList.asSequence()
            .filterNot { it.size.contains("Varies with device") }
            .sortedByDescending { it.size.calculateSize() }
            .map { it.appName }
            .take(number)
            .toList()
    else null

private fun String.calculateSize(): Double =
    when (this.last()) {
        'G' -> {
            this.removeLastCharacter() * 1000000.0
        }
        'M' -> {
            this.removeLastCharacter() * 1000.0
        }
        else -> {
            this.removeLastCharacter() * 1.0
        }
    }

private fun String.removeLastCharacter() = this.removeSuffix(this.last().toString()).toDouble()


//Req6 -Find Top Ten App Install.#Nooralden
fun topTenAppInstall(appDataList: List<App>, number: Int): List<String>? =
    if (appDataList.isNotEmpty())
        appDataList.asSequence()
            .sortedByDescending { dataSorted -> dataSorted.installs }
            .map { data -> data.appName }
            .take(number)
            .toList()
    else null

