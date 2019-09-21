package kz.kairliyev.salon_almaty.interactor


import kz.kairliyev.salon_almaty.model.SalonResponse
import rx.Observable


interface SalonAppInteractor{
    fun getPopularSalons(): Observable<SalonResponse>
    fun getRecommendedSalons(): Observable<SalonResponse>
}