package kz.kairliyev.salon_almaty.ui.home

import kz.kairliyev.salon_almaty.model.Salon

interface HomeFragmentView {
    fun showPopularSalons(salons : ArrayList<Salon>?)
    fun showRecommendedSalons(salons : ArrayList<Salon>?)
    fun showLoading()
    fun hideLoading()
}