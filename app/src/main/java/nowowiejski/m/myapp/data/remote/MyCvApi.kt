package nowowiejski.m.myapp.data.remote

import io.reactivex.rxjava3.core.Single
import nowowiejski.m.myapp.data.remote.model.CvDto

interface MyCvApi {

    fun getCv(): Single<CvDto>

}