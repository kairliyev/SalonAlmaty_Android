package kz.kairliyev.salon_almaty.ui.home.presenter

import kz.kairliyev.salon_almaty.model.Salon
import kz.kairliyev.salon_almaty.ui.home.HomeFragmentView

interface HomePresenter {
    fun setView(homeFragmentView: HomeFragmentView)
    fun loadSavedView(
        homeFragmentView: HomeFragmentView,
        popularObject: ArrayList<Salon>,
        recommendedObject: ArrayList<Salon>)
}