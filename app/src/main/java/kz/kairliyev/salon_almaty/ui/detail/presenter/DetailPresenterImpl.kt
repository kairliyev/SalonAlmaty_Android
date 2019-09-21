package kz.kairliyev.salon_almaty.ui.detail.presenter

import android.util.Log
import kz.kairliyev.salon_almaty.interactor.DetailInteractor
import kz.kairliyev.salon_almaty.model.DetailResponse
import kz.kairliyev.salon_almaty.ui.detail.DetailView
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class DetailPresenterImpl(val interactor: DetailInteractor, private var view: DetailView?): DetailPresenter{
    override fun setView(detailView: DetailView, id: String) {
        view = detailView
        getDetails(id)
    }

    private fun getDetails(id: String) {
        interactor.getSalonDetails(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { detailResponse -> onDetailsSuccess(detailResponse) },
                { e -> onDetailsFailure(e) }
            )
    }

    private fun onDetailsFailure(e: Throwable?) {
        Log.d("Details", e.toString())
    }

    private fun onDetailsSuccess(detailResponse: DetailResponse?) {
        view?.showSalonDetails(detailResponse)
    }
}