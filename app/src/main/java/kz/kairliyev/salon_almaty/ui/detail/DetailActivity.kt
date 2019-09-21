package kz.kairliyev.salon_almaty.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_detail.*
import kz.kairliyev.master_almaty.ui.detail.adapters.MasterAdapter
import kz.kairliyev.salon_almaty.App
import kz.kairliyev.salon_almaty.R
import kz.kairliyev.salon_almaty.model.DetailResponse
import kz.kairliyev.salon_almaty.ui.detail.adapters.ImageSliderAdapter
import kz.kairliyev.salon_almaty.ui.detail.presenter.DetailPresenter
import javax.inject.Inject

class DetailActivity : AppCompatActivity() , DetailView{

    @Inject
    lateinit var presenter: DetailPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setSupportActionBar(toolbar)
        title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        (applicationContext as App).createDetailComponent().inject(this)
        val id = intent.getStringExtra("id")
        initLayout()
        presenter.setView(this, id)

    }

    private fun initLayout() {
        val layoutManager = LinearLayoutManager(this)
        masters_list.layoutManager = layoutManager
        masters_list.adapter = MasterAdapter(this)
    }

    override fun showSalonDetails(salon: DetailResponse?) {
        imageSlider.sliderAdapter = ImageSliderAdapter(this, salon?.salon?.getFullPathListImage)
        title_salon.text = salon?.salon?.name
        type.text = salon?.salon?.type
        description.text = salon?.salon?.address

        (masters_list.adapter as MasterAdapter).addMasters(salon!!.masters)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            onBackPressed()
            return true
        }

        return super.onOptionsItemSelected(item)
    }

}
