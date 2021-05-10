package nowowiejski.m.myapp.domain.base

import io.reactivex.rxjava3.core.Scheduler

data class UseCaseScheduler(val run: Scheduler, val post: Scheduler)
