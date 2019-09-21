package kz.kairliyev.salon_almaty.model

import com.google.gson.annotations.SerializedName

data class Salon(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("type") val type: String,
    @SerializedName("checkRating") val checkRating: Int,
    @SerializedName("pictureUrl") val pictureUrl: String
) {
    val getFullImageUrl: String
        get() = "http://zp.jgroup.kz$pictureUrl"
}