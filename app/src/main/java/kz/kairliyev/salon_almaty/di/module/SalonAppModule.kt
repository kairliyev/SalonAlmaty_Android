package kz.kairliyev.salon_almaty.di.module

import dagger.Module
import dagger.Provides
import kz.kairliyev.salon_almaty.api.SalonApi
import kz.kairliyev.salon_almaty.di.AppScope
import kz.kairliyev.salon_almaty.interactor.SalonAppInteractor
import kz.kairliyev.salon_almaty.interactor.SalonAppInteractorImpl
import kz.kairliyev.salon_almaty.ui.home.presenter.HomePresenter
import kz.kairliyev.salon_almaty.ui.home.presenter.HomePresenterImpl

@Module
class SalonAppModule {
    @Provides
    @AppScope
    fun provideMainInteractor(api : SalonApi): SalonAppInteractor {
        return SalonAppInteractorImpl(api)
    }

    @Provides
    fun provideHomePresenter(salonInteractor: SalonAppInteractor): HomePresenter {
        return HomePresenterImpl(salonInteractor, null)
    }

}