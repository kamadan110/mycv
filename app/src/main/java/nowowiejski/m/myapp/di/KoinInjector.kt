package nowowiejski.m.myapp.di

val koinInjector = listOf(
    networkModule,
    appModule,
    schedulerModule,
    featureModule
)