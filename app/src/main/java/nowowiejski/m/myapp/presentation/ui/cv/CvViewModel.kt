package nowowiejski.m.myapp.presentation.ui.cv

import android.util.Log
import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.kotlin.addTo
import nowowiejski.m.myapp.domain.GetCvUseCase
import nowowiejski.m.myapp.presentation.model.Event
import nowowiejski.m.myapp.presentation.model.MyCvDisplayable

class CvViewModel(private val getCvUseCase: GetCvUseCase) : CvBaseViewModel() {

    override val isLoading = MutableLiveData(false)
    override val cv = MutableLiveData<MyCvDisplayable>()
    override val navigateToDetailAction = MutableLiveData<Event<String>>()

    override fun loadData() {
        isLoading.value = true
        getCvUseCase(Unit).map {
            MyCvDisplayable(it)
        }.subscribe({
            isLoading.value = false
            cv.value = it
        }, { error ->
            isLoading.value = false
            Log.e(CvViewModel::class.java.simpleName, "loadData", error)
        }).addTo(disposable)
    }

    override fun onItemClicked(myCv: MyCvDisplayable) {

    }
}