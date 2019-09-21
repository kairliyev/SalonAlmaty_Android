package kz.kairliyev.salon_almaty.ui.detail.presenter

import kz.kairliyev.salon_almaty.ui.detail.DetailView

interface DetailPresenter {
    fun setView(detailView: DetailView, id: String)
}