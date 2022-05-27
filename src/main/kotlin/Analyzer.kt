import model.App
import kotlin.math.roundToInt


//Req1 -Find Count Of App Develop by Google.#Nooralden
fun countAppsDevelopByGoogle(appDataList: List<App>, companyName: String): Int =
    appDataList.count { it.company.contains(companyName) }


//Req2 -Find Percentage of Category.#Nada
fun getPercentageOfCategory(appDataList: List<App>, categoryName: String): Double =
    appDataList.count { it.category.contains(categoryName) }
        .div(appDataList.size.toDouble()).times(100)
        .times(100).roundToInt().toDouble() / 100


//Req3 -Find Oldest App.#Nada
fun findOldestApp(appDataList: List<App>): String =
    appDataList.sortedBy { it.updatedDate }.first().appName


//Req4 -Find Percentage Of App Running On Android 9.#Rash
fun percentageAppsRunningOnAndroid9(appDataList: List<App>, requiresAndroid: String): Int =
    appDataList.asSequence().filter { it.requiresAndroid.contains(requiresAndroid) }
        .map { String.format("%.1f", 100.0 * it.requiresAndroid.count() / appDataList.size) }.count()


//Req5 -Find The Largest Top Ten Apps.#Nooralden
fun theLargestTopTenApps(appDataList: List<App>, number: Int): List<String?> =
    appDataList.asSequence()
        .filterNot { it.size.contains("Varies with device") }
        .sortedByDescending { it.size.calculateSize() }
        .map { it.appName }
        .take(number)
        .toList()


private fun String.calculateSize(): Double =
    when (this.last()) {
        'G' -> {
            this.removeLastCharacter(this.last()) * 1000000.0
        }
        'M' -> {
            this.removeLastCharacter(this.last()) * 1000.0
        }
        else -> {
            this.removeLastCharacter(this.last()) * 1.0
        }
    }

private fun String.removeLastCharacter(text: Char) = this.removeSuffix(text.toString()).toDouble()


//Req6 -Find Top Ten App Install.#Nooralden
fun topTenAppInstall(appDataList: List<App>, number: Int): List<String> =
    appDataList.asSequence()
        .sortedByDescending { dataSorted -> dataSorted.installs }
        .map { data -> data.appName }
        .take(number)
        .toList()
