package nowowiejski.m.myapp

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import nowowiejski.m.myapp.di.koinInjector
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin()
        AndroidThreeTen.init(this)
    }

    private fun startKoin() {
        startKoin {
            androidContext(this@MyApplication)
            modules(koinInjector)
        }
    }
}