package kz.kairliyev.salon_almaty.di.component

import dagger.Component
import kz.kairliyev.salon_almaty.di.module.AppModule
import kz.kairliyev.salon_almaty.api.ApiModule
import kz.kairliyev.salon_almaty.di.module.DetailModule
import kz.kairliyev.salon_almaty.di.module.SalonAppModule
import kz.kairliyev.salon_almaty.di.module.NetworkModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class), (NetworkModule::class), (ApiModule::class)])
interface AppComponent{
    fun plus(salonAppModule: SalonAppModule): SalonAppComponent
    fun plus(detailModule: DetailModule): DetailComponent
}