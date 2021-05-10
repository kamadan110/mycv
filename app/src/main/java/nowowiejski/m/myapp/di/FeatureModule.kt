package nowowiejski.m.myapp.di

import nowowiejski.m.myapp.data.repository.CvRepositoryImpl
import nowowiejski.m.myapp.domain.GetCvUseCase
import nowowiejski.m.myapp.domain.repository.CvRepository
import nowowiejski.m.myapp.presentation.ui.cv.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val featureModule = module {
    //Repository
    factory<CvRepository> { CvRepositoryImpl(get()) }

    //Use Case
    factory { GetCvUseCase(get(), get()) }

    scope(named<CvFragment>()) {
        viewModel<CvBaseViewModel> { CvViewModel(get()) }
        factory { CvAdapter() }
    }
}