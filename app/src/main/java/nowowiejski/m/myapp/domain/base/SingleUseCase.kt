package nowowiejski.m.myapp.domain.base

import io.reactivex.rxjava3.core.Single

abstract class SingleUseCase<Type, in Params>(private val useCaseScheduler: UseCaseScheduler?) {

    abstract fun action(params: Params): Single<Type>

    operator fun invoke(
            params: Params
    ): Single<Type> {
        return this.action(params)
            .compose { transformer ->
                useCaseScheduler?.let {
                    transformer.subscribeOn(useCaseScheduler.run).observeOn(useCaseScheduler.post)
                } ?: transformer
            }
    }
}