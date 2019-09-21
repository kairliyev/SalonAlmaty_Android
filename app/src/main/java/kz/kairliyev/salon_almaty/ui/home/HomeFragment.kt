package kz.kairliyev.salon_almaty.ui.home


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.fragment_home.*
import kz.kairliyev.salon_almaty.App
import kz.kairliyev.salon_almaty.R
import kz.kairliyev.salon_almaty.model.Salon
import kz.kairliyev.salon_almaty.ui.detail.DetailActivity
import kz.kairliyev.salon_almaty.ui.home.adapters.Callback
import kz.kairliyev.salon_almaty.ui.home.adapters.SalonAdapter
import kz.kairliyev.salon_almaty.ui.home.presenter.HomePresenter
import javax.inject.Inject

class HomeFragment : Fragment(), HomeFragmentView, Callback {

    @Inject
    lateinit var presenter: HomePresenter

    @Inject
    lateinit var gson: Gson

    private var rec: ArrayList<Salon> = ArrayList()
    private var pop: ArrayList<Salon> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (context?.applicationContext as App).createMainComponent().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        if (savedInstanceState != null) {
//            var popularJson = savedInstanceState.getString("popularSalons", "1")
//
//            var popularObject: ArrayList<Salon> =
//                gson.fromJson(popularJson, object : TypeToken<ArrayList<Salon>>() {}.type)
//
//            var recommendedJson = savedInstanceState.getString("recommendedSalons", "2")
//            var recommendedObject: ArrayList<Salon> =
//                gson.fromJson(recommendedJson, object : TypeToken<ArrayList<Salon>>() {}.type)
//
//            setUp()
//            presenter.loadSavedView(this, popularObject, recommendedObject)
//        } else {
//            presenter.setView(this)
//            setUp()
//        }
        presenter.setView(this)
        setUp()

    }

    private fun setUp() {
        list_popular.setHasFixedSize(true)
        val layoutManagerPopular = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        list_popular.layoutManager = layoutManagerPopular
        list_popular.adapter = SalonAdapter(context, this)

        list_recommended.setHasFixedSize(true)
        val layoutManagerRecommended = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        list_recommended.layoutManager = layoutManagerRecommended
        list_recommended.adapter = SalonAdapter(context, this)
    }

    override fun onSalonClicked(id: Int) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra("id",id.toString())

        context?.let {
            startActivity(intent)
            Toast.makeText(context, "$id", Toast.LENGTH_LONG).show()
        }
    }

    override fun showPopularSalons(salons: ArrayList<Salon>?) {
        if (salons != null) {
            (list_popular.adapter as SalonAdapter).addSalons(salons)
            addPopSalons(salons)
        }
    }

    fun addPopSalons(salons: ArrayList<Salon>?) {
        if (salons != null) {
            this.pop.addAll(salons)
        }
    }

    fun addRecSalons(salons: ArrayList<Salon>?) {
        if (salons != null) {
            this.rec.addAll(salons)
        }
    }

    override fun showRecommendedSalons(salons: ArrayList<Salon>?) {
        if (salons != null) {
            (list_recommended.adapter as SalonAdapter).addSalons(salons)
        }
        addRecSalons(salons)
    }

    override fun showLoading() {
        content_ll.visibility = View.GONE
    }

    override fun hideLoading() {
        content_ll.visibility = View.VISIBLE
        progress_bar.visibility = View.GONE
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
//        var jsonPopularString = gson.toJson(pop)
//        var jsonRecommendedString = gson.toJson(rec)
//        outState.putString("popularSalons", jsonPopularString)
//        outState.putString("recommendedSalons", jsonRecommendedString)
    }


}
