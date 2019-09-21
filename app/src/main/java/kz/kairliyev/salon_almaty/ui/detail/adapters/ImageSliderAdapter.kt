package kz.kairliyev.salon_almaty.ui.detail.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.smarteist.autoimageslider.SliderViewAdapter
import kotlinx.android.synthetic.main.image_slider_layout_item.view.*
import kz.kairliyev.salon_almaty.R

class ImageSliderAdapter(
    private val context: Context,
    internal val fullPathListImage: List<String>?
) : SliderViewAdapter<ImageSliderAdapter.ViewHolder>() {
    private var imageList: ArrayList<String> =
        arrayListOf()

    override fun getCount(): Int {
        return fullPathListImage!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.image_slider_layout_item, null)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder?, position: Int) {
        Glide.with(context).load(fullPathListImage?.get(position)).into(viewHolder!!.iv)
    }

    inner class ViewHolder(root: View) : SliderViewAdapter.ViewHolder(root) {
        var iv: ImageView = root.iv_auto_image_slider
    }
}