package datasource.jsondatasourse

import model.App
import org.json.JSONArray
import org.json.JSONObject
import datasource.IDataSource
import util.Constant
import java.io.File

class JsonDataParser(private var fileName: String = Constant.JSON_FILE_NAME) : IDataSource {
    override fun getAllData(): List<App> {
        val list = mutableListOf<App>()
        File(fileName).readText().also { mFile ->
            JSONArray(mFile).forEach { any: Any? ->
                JSONObject(any.toString()).apply {
                    list.add(JsonParser.parse(this))
                }
            }
        }
        return list
    }
}


