package nowowiejski.m.myapp.data.repository

import io.reactivex.rxjava3.core.Single
import nowowiejski.m.myapp.data.remote.MyCvApi
import nowowiejski.m.myapp.domain.model.MyCv
import nowowiejski.m.myapp.domain.repository.CvRepository

class CvRepositoryImpl(
    private val cvApi: MyCvApi
) : CvRepository {

    override fun getCV(): Single<MyCv> {
        return cvApi.getCv().map { cvDto ->
            cvDto.mapToDomain()
        }
    }

}