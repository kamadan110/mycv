package nowowiejski.m.myapp.presentation.ui.cv

import androidx.lifecycle.LiveData
import nowowiejski.m.myapp.presentation.base.BaseViewModel
import nowowiejski.m.myapp.presentation.model.Event
import nowowiejski.m.myapp.presentation.model.MyCvDisplayable

abstract class CvBaseViewModel: BaseViewModel() {
    abstract val isLoading: LiveData<Boolean>
    abstract val cv: LiveData<MyCvDisplayable>
    abstract val navigateToDetailAction: LiveData<Event<String>>
    abstract fun loadData()
    abstract fun onItemClicked(myCv: MyCvDisplayable)
}