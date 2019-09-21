package kz.kairliyev.salon_almaty.di.module

import dagger.Module
import dagger.Provides
import kz.kairliyev.salon_almaty.api.SalonApi
import kz.kairliyev.salon_almaty.di.AppScope
import kz.kairliyev.salon_almaty.interactor.DetailInteractor
import kz.kairliyev.salon_almaty.interactor.DetailInteractorImpl
import kz.kairliyev.salon_almaty.ui.detail.presenter.DetailPresenter
import kz.kairliyev.salon_almaty.ui.detail.presenter.DetailPresenterImpl

@Module
class DetailModule {
    @Provides
    fun provideDetailPresenter(detailInteractor: DetailInteractor): DetailPresenter {
        return DetailPresenterImpl(detailInteractor, null)
    }

    @Provides
    @AppScope
    fun provideDetailInteractor(api : SalonApi): DetailInteractor {
        return DetailInteractorImpl(api)
    }
}