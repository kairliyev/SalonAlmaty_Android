package kz.kairliyev.salon_almaty.interactor

import kz.kairliyev.salon_almaty.model.DetailResponse
import rx.Observable

interface DetailInteractor {
    fun getSalonDetails(id: String): Observable<DetailResponse>
}