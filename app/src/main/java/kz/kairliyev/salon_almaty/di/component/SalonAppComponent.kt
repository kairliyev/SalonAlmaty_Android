package kz.kairliyev.salon_almaty.di.component

import dagger.Subcomponent
import kz.kairliyev.salon_almaty.di.AppScope
import kz.kairliyev.salon_almaty.di.module.SalonAppModule
import kz.kairliyev.salon_almaty.ui.home.HomeFragment

@AppScope
@Subcomponent(modules = [(SalonAppModule::class)])
interface SalonAppComponent {
    fun inject(target: HomeFragment)
}