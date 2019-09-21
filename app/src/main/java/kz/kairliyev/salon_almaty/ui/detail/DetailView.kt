package kz.kairliyev.salon_almaty.ui.detail

import kz.kairliyev.salon_almaty.model.DetailResponse

interface DetailView {
    fun showSalonDetails(salon: DetailResponse?)
}