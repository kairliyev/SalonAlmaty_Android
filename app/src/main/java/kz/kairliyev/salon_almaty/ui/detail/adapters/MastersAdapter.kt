package kz.kairliyev.master_almaty.ui.detail.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_masters.view.*
import kz.kairliyev.salon_almaty.R
import kz.kairliyev.salon_almaty.model.Master

class MasterAdapter(private val context: Context?) :
    RecyclerView.Adapter<MasterAdapter.ViewHolder>() {
    private var masters: ArrayList<Master> = ArrayList()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(masters[position])
    }

    override fun getItemCount(): Int {
        return masters.size
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val root = (LayoutInflater.from(parent.context).inflate(R.layout.item_masters, parent, false))
        return ViewHolder(root)
    }

    fun addMasters(masters: ArrayList<Master>) {
        this.masters.addAll(masters)
        notifyDataSetChanged()
    }

    inner class ViewHolder(root: View) : RecyclerView.ViewHolder(root) {
        init {
            itemView.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                }
            }
        }

        fun bind(master: Master) = with(itemView) {
            master_name_tv.text = master.name
            master_type_tv.text = master.profession
            Glide.with(context).load(master.getFullImageUrl).into(avatar_iv)
        }
    }
}