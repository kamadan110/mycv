package nowowiejski.m.myapp.di

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import nowowiejski.m.myapp.domain.base.UseCaseScheduler
import org.koin.dsl.module

val schedulerModule = module {
    factory { UseCaseScheduler(Schedulers.io(), AndroidSchedulers.mainThread()) }
}