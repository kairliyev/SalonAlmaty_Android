package kz.kairliyev.salon_almaty.model

import com.google.gson.annotations.SerializedName

data class SalonResponse(@SerializedName("salons") val salons: ArrayList<Salon>)