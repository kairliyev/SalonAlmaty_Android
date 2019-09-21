package kz.kairliyev.salon_almaty

import android.app.Application
import kz.kairliyev.salon_almaty.di.component.AppComponent
import kz.kairliyev.salon_almaty.di.component.DaggerAppComponent
import kz.kairliyev.salon_almaty.di.component.DetailComponent
import kz.kairliyev.salon_almaty.di.component.SalonAppComponent
import kz.kairliyev.salon_almaty.di.module.AppModule
import kz.kairliyev.salon_almaty.di.module.DetailModule
import kz.kairliyev.salon_almaty.di.module.SalonAppModule
import kz.kairliyev.salon_almaty.di.module.NetworkModule

@Suppress("DEPRECATION")
class App : Application() {

    lateinit var appComponent : AppComponent
    lateinit var salonComponent: SalonAppComponent
    lateinit var detailComponent : DetailComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = createAppComponent()
    }

    private fun createAppComponent(): AppComponent {
        return DaggerAppComponent.builder()
            .networkModule(NetworkModule())
            .appModule(AppModule(this)).build()
    }

    fun createMainComponent(): SalonAppComponent {
        salonComponent = appComponent.plus(SalonAppModule())
        return salonComponent
    }

    fun createDetailComponent(): DetailComponent {
        detailComponent = appComponent.plus(DetailModule())
        return detailComponent
    }
}