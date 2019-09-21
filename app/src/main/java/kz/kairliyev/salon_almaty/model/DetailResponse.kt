package kz.kairliyev.salon_almaty.model

import com.google.gson.annotations.SerializedName
import kotlin.collections.ArrayList

data class DetailResponse (
    @SerializedName("salon") val salon: SalonSingle,
    @SerializedName("masters") val masters: ArrayList<Master>
)