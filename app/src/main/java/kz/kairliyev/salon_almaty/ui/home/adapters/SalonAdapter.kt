package kz.kairliyev.salon_almaty.ui.home.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_popular_salon.view.*
import kz.kairliyev.salon_almaty.R
import kz.kairliyev.salon_almaty.model.Salon


class SalonAdapter(private val context: Context?, private var callback: Callback) :
    RecyclerView.Adapter<SalonAdapter.ViewHolder>() {
    private var salons: ArrayList<Salon> = ArrayList()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(salons[position])
    }

    override fun getItemCount(): Int {
        return salons.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val root = (LayoutInflater.from(parent.context).inflate(R.layout.item_popular_salon, parent, false))
        return ViewHolder(root)
    }

    fun addSalons(salons: ArrayList<Salon>) {
        this.salons.addAll(salons)
        notifyDataSetChanged()
    }

    inner class ViewHolder(root: View) : RecyclerView.ViewHolder(root) {
        init {
            itemView.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    callback.onSalonClicked(salons[adapterPosition].id)
                }
            }
        }

        fun bind(salon: Salon) = with(itemView) {
            salon_title_tv.text = salon.name
            salon_type_tv.text = salon.type
            salon_rating_rb.rating = salon.checkRating.toFloat()
            Glide.with(context).load(salon.getFullImageUrl).into(salon_background_iv)
        }
    }
}