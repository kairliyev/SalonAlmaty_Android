package kz.kairliyev.salon_almaty.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kz.kairliyev.salon_almaty.R
import kz.kairliyev.salon_almaty.ui.home.HomeFragment
import kz.kairliyev.salon_almaty.ui.profile.ProfileFragment
import kz.kairliyev.salon_almaty.ui.search.SearchFragment
import kz.kairliyev.salon_almaty.utils.removeFragment

class MainActivity : AppCompatActivity() {
    companion object TAGS {
        const val HOME_FRAGMENT = "HOME_FRAGMENT"
        const val SEARCH_FRAGMENT = "SEARCH_FRAGMENT"
        const val PROFILE_FRAGMENT = "PROFILE_FRAGMENT"
    }

    private var state: Bundle = Bundle()
    private var listFragment: List<Fragment> =
        listOf(HomeFragment(), SearchFragment(), ProfileFragment())
    private var selectedFragment: Int = 0

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        val transaction = supportFragmentManager.beginTransaction()
        when (item.itemId) {
            R.id.navigation_home -> {
                if (selectedFragment != 0) {
                    transaction.show(listFragment[0]).hide(listFragment[selectedFragment])
                    selectedFragment = 0
                }
            }
            R.id.navigation_search -> {
                if (selectedFragment != 1) {
                    transaction.show(listFragment[1]).hide(listFragment[selectedFragment])
                    selectedFragment = 1
                }
            }
            else -> {
                if (selectedFragment != 2) {
                    transaction.show(listFragment[2]).hide(listFragment[selectedFragment])
                    selectedFragment = 2
                }
            }
        }
        transaction.commit()
        true
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {
            selectedFragment = savedInstanceState.getInt("pageIndex", 0)
            val navView: BottomNavigationView = findViewById(R.id.nav_view)
            navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
            fragmentRemoveStack()
            fragmentPositionInit()
        } else {
            val navView: BottomNavigationView = findViewById(R.id.nav_view)
            navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
            fragmentPositionInit()
        }
    }

    private fun fragmentRemoveStack() {
        supportFragmentManager.removeFragment(HOME_FRAGMENT)
        supportFragmentManager.removeFragment(SEARCH_FRAGMENT)
        supportFragmentManager.removeFragment(PROFILE_FRAGMENT)
    }

    private fun fragmentPositionInit() {
        if (selectedFragment == 0) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, listFragment[0], HOME_FRAGMENT).show(listFragment[0])
                .add(R.id.container, listFragment[1], SEARCH_FRAGMENT).hide(listFragment[1])
                .add(R.id.container, listFragment[2], PROFILE_FRAGMENT).hide(listFragment[2])
                .commit()
        } else if (selectedFragment == 1) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, listFragment[0], HOME_FRAGMENT).hide(listFragment[0])
                .add(R.id.container, listFragment[1], SEARCH_FRAGMENT).show(listFragment[1])
                .add(R.id.container, listFragment[2], PROFILE_FRAGMENT).hide(listFragment[2])
                .commit()
        } else if (selectedFragment == 2) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, listFragment[0], HOME_FRAGMENT).hide(listFragment[0])
                .add(R.id.container, listFragment[1], SEARCH_FRAGMENT).hide(listFragment[1])
                .add(R.id.container, listFragment[2], PROFILE_FRAGMENT).show(listFragment[2])
                .commit()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("pageIndex", selectedFragment)
    }
}
