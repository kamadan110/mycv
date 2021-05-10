package nowowiejski.m.myapp.domain

import io.reactivex.rxjava3.core.Single
import nowowiejski.m.myapp.domain.base.SingleUseCase
import nowowiejski.m.myapp.domain.base.UseCaseScheduler
import nowowiejski.m.myapp.domain.model.MyCv
import nowowiejski.m.myapp.domain.repository.CvRepository

class GetCvUseCase(
    private val cvRepository: CvRepository,
    scheduler: UseCaseScheduler? = null
) : SingleUseCase<MyCv, Unit>(scheduler) {

    override fun action(params: Unit): Single<MyCv> {
        return cvRepository.getCV()
    }
}