package kz.kairliyev.salon_almaty.model

import com.google.gson.annotations.SerializedName

data class SalonSingle (

	@SerializedName("id") val id : Int,
	@SerializedName("name") val name : String,
	@SerializedName("address") val address : String,
	@SerializedName("workStartTime") val workStartTime : String,
	@SerializedName("workEndTime") val workEndTime : String,
	@SerializedName("type") val type : String,
	@SerializedName("checkRating") val checkRating : Int,
	@SerializedName("pictures") val pictures : List<String>,
	@SerializedName("phoneNumbers") val phoneNumbers : List<String>
) {
	val getFullPathListImage: List<String>
		get() {
			var list: MutableList<String> = mutableListOf()
			for ((i,v) in pictures.withIndex()){
				var path = "http://zp.jgroup.kz${pictures[i]}"
				list.add(path)
			}
			return list
		}
}