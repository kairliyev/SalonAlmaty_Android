package kz.kairliyev.salon_almaty.di.component

import dagger.Subcomponent
import kz.kairliyev.salon_almaty.di.AppScope
import kz.kairliyev.salon_almaty.di.module.DetailModule
import kz.kairliyev.salon_almaty.ui.detail.DetailActivity

@AppScope
@Subcomponent(modules = [(DetailModule::class)])
interface DetailComponent {
    fun inject(target: DetailActivity)
}