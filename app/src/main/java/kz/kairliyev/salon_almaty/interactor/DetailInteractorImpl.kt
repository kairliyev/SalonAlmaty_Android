package kz.kairliyev.salon_almaty.interactor

import kz.kairliyev.salon_almaty.api.SalonApi
import kz.kairliyev.salon_almaty.model.DetailResponse
import rx.Observable

class DetailInteractorImpl(private val api: SalonApi): DetailInteractor{
    override fun getSalonDetails(id: String): Observable<DetailResponse> {
        return api.getSalonDetails(createQueryMap(id))
    }

    private fun createQueryMap(id: String): Map<String, String>{
        return hashMapOf(
            "id" to id
        )
    }
}