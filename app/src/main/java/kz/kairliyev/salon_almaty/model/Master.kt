package kz.kairliyev.salon_almaty.model

import com.google.gson.annotations.SerializedName

data class Master(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("surname") val surname: String,
    @SerializedName("profession") val profession: String,
    @SerializedName("avatarUrl") val avatarUrl: String


) {
    val getFullImageUrl: String
        get() = "http://zp.jgroup.kz$avatarUrl"
}