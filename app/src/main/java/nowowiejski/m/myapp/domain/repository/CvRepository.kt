package nowowiejski.m.myapp.domain.repository

import io.reactivex.rxjava3.core.Single
import nowowiejski.m.myapp.domain.model.MyCv

interface CvRepository {
    fun getCV(): Single<MyCv>
}