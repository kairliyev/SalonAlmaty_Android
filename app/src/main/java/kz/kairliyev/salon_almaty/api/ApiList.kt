package kz.kairliyev.salon_almaty.api

import kz.kairliyev.salon_almaty.model.DetailResponse
import kz.kairliyev.salon_almaty.model.SalonResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap
import rx.Observable

interface SalonApi {

    @GET("salon/getPopular/")
    fun getPopularSalons(): Observable<SalonResponse>

    @GET("salon/getRecommended/")
    fun getRecommendedSalons(): Observable<SalonResponse>

    @GET("salon/page")
    fun getSalonDetails(@QueryMap map: Map<String, String>): Observable<DetailResponse>
}