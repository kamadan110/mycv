package nowowiejski.m.myapp.di

import com.google.gson.Gson
import nowowiejski.m.myapp.BuildConfig
import nowowiejski.m.myapp.data.remote.CvRemoteDataSource
import nowowiejski.m.myapp.data.remote.MyCvApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val networkModule = module {

    single<Interceptor> {
        HttpLoggingInterceptor()
            .apply {
                level =
                    if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                    else HttpLoggingInterceptor.Level.NONE
            }
    }

    single {
        OkHttpClient.Builder()
            .addInterceptor(get<Interceptor>())
            .build()
    }

    single { Gson() }
    single<MyCvApi> { CvRemoteDataSource(get(), androidContext()) }
}