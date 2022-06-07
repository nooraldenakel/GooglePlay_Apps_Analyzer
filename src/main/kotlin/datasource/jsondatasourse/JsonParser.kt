package datasource.jsondatasourse

import model.App
import org.json.JSONObject
import util.Constant
import util.convertStringToDate
import util.convertToDouble
import util.convertToMegaByte

object JsonParser {
    fun parse(jsonObject: JSONObject): App {
        return App(
            appName = jsonObject.getString(Constant.JsonColumIndex.APP_NAME),
            company = jsonObject.getString(Constant.JsonColumIndex.COMPANY),
            category = jsonObject.getString(Constant.JsonColumIndex.CATEGORY),
            updated = jsonObject.getString(Constant.JsonColumIndex.UPDATE_DATE).convertStringToDate(),
            size = jsonObject.getString(Constant.JsonColumIndex.SIZE).convertToMegaByte(),
            installs = jsonObject.getInt(Constant.JsonColumIndex.INSTALLS).toLong(),
            requiresAndroid = jsonObject.getString(Constant.JsonColumIndex.REQUIRED_ANDROID).convertToDouble(),
        )
    }
}