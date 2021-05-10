package nowowiejski.m.myapp.presentation.base

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {

    protected lateinit var disposable: CompositeDisposable

    init {
        subscribe()
    }

    private fun subscribe() {
        disposable = CompositeDisposable()
    }

    private fun unSubscribe() {
        if (!disposable.isDisposed) disposable.dispose()
    }

    override fun onCleared() {
        unSubscribe()
        super.onCleared()
    }

}