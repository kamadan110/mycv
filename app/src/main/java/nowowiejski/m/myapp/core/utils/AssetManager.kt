package nowowiejski.m.myapp.core.utils

import android.content.Context
import io.reactivex.rxjava3.core.Single
import java.io.IOException

object AssetManager {

    private fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

    fun getAssetStringAsync(context: Context, filePath: String): Single<String> {
        return Single.fromCallable {
            getJsonDataFromAsset(
                context,
                filePath
            )
        }
    }
}



