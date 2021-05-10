package nowowiejski.m.myapp.di

import android.content.Context
import android.net.ConnectivityManager
import nowowiejski.m.myapp.core.network.NetworkStateProvider
import nowowiejski.m.myapp.core.network.NetworkStateProviderImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    factory { androidContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager }
    factory<NetworkStateProvider> { NetworkStateProviderImpl(get()) }
}