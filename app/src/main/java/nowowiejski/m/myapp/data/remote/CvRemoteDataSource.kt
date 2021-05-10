package nowowiejski.m.myapp.data.remote

import android.content.Context
import com.google.gson.Gson
import io.reactivex.rxjava3.core.Single
import nowowiejski.m.myapp.core.utils.AssetManager
import nowowiejski.m.myapp.data.remote.model.CvDto

class CvRemoteDataSource(private val gson: Gson,
                         private val context: Context): MyCvApi {

    override fun getCv(): Single<CvDto> =
         AssetManager.getAssetStringAsync(context, "cv.json")
             .map { gson.fromJson(it, CvDto::class.java) }

}
