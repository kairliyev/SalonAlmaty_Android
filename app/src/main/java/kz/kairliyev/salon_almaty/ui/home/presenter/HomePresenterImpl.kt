package kz.kairliyev.salon_almaty.ui.home.presenter


import android.util.Log
import androidx.annotation.NonNull
import kz.kairliyev.salon_almaty.interactor.SalonAppInteractor
import kz.kairliyev.salon_almaty.model.Salon
import kz.kairliyev.salon_almaty.model.SalonResponse
import kz.kairliyev.salon_almaty.ui.home.HomeFragmentView
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class HomePresenterImpl(private val interactor: SalonAppInteractor, private var view: HomeFragmentView?) :
    HomePresenter {
    private var rec: ArrayList<Salon> = ArrayList()
    private var pop: ArrayList<Salon> = ArrayList()

    override fun loadSavedView(
        homeFragmentView: HomeFragmentView,
        popularObject: ArrayList<Salon>,
        recommendedObject: ArrayList<Salon>
    ) {
        view = homeFragmentView
        onGetSavedSalons(popularObject, recommendedObject)
    }

    private fun onGetSavedSalons(popularObject: ArrayList<Salon>, recommendedObject: ArrayList<Salon>) {
            pop.addAll(popularObject)
            rec.addAll(recommendedObject)
            showSavedUI()
    }

    override fun setView(homeFragmentView: HomeFragmentView) {
        view = homeFragmentView
        view?.showLoading()
        getRecommendedSalons()
        getPopularSalons()
    }

    private fun getRecommendedSalons() {
        interactor.getRecommendedSalons()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { recommendedSalonsResponse -> onGetRecommendedSalonsSuccess(recommendedSalonsResponse) },
                { e -> onGetRecommendedSalonsFailure(e) }
            )
    }

    private fun onGetRecommendedSalonsFailure(e: Throwable?) {
        Log.e("RecSalons", e.toString())
    }

    private fun onGetRecommendedSalonsSuccess(salonResponse: SalonResponse?) {
        rec.addAll(salonResponse!!.salons)
        showUI()
    }

    private fun getPopularSalons() {
        interactor.getPopularSalons()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { popularSalonsResponse -> onGetPopularSalonsSuccess(popularSalonsResponse) },
                { e -> onGetPopularSalonsFailure(e) }
            )
    }

    private fun onGetPopularSalonsFailure(e: Throwable?) {
        Log.e("PopularSalons", e.toString())
    }

    private fun onGetPopularSalonsSuccess(popularSalonsResponse: SalonResponse?) {
        pop.addAll(popularSalonsResponse!!.salons)
        showUI()
    }

    private fun showUI() {
        if (rec.size > 0 && pop.size > 0) {
            view?.showRecommendedSalons(rec)
            view?.showPopularSalons(pop)
            rec.clear()
            pop.clear()
            view?.hideLoading()
        }
    }

    private fun showSavedUI() {
        if (rec.size > 0 && pop.size > 0) {
            view?.showRecommendedSalons(rec)
            view?.showPopularSalons(pop)
            rec.clear()
            pop.clear()
        }
    }

}