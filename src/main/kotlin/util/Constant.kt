package util

object Constant {
    object CSVColumIndex{
        const val APP_NAME = 0
        const val COMPANY = 1
        const val CATEGORY = 2
        const val UPDATE_DATE = 3
        const val SIZE = 4
        const val INSTALLS = 5
        const val REQUIRED_ANDROID = 7
    }
    object JsonColumIndex{
        const val APP_NAME = "appName"
        const val COMPANY = "company"
        const val CATEGORY = "category"
        const val UPDATE_DATE = "updated"
        const val SIZE = "size"
        const val INSTALLS = "installs"
        const val REQUIRED_ANDROID = "requiresAndroid"
    }
    const val CSV_FILE_NAME = "google_play.csv"
    const val JSON_FILE_NAME = "google_play.json"
    const val DATE_FORMAT="MMM d yyyy"
    const val KILO_BYTE = 1024.0
    const val MIN_COMPARE_INT = 1
}