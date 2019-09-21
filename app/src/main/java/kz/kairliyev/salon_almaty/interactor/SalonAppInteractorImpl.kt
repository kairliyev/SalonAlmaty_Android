package kz.kairliyev.salon_almaty.interactor

import kz.kairliyev.salon_almaty.api.SalonApi
import kz.kairliyev.salon_almaty.model.SalonResponse
import rx.Observable

class SalonAppInteractorImpl(private val salonApi: SalonApi) : SalonAppInteractor {

    override fun getPopularSalons(): Observable<SalonResponse> {
        return salonApi.getPopularSalons()
    }

    override fun getRecommendedSalons(): Observable<SalonResponse> {
        return salonApi.getRecommendedSalons()
    }
}