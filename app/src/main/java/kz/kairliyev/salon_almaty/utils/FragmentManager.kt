package kz.kairliyev.salon_almaty.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

internal fun FragmentManager.removeFragment(tag: String) {
    this.beginTransaction()
        .remove(this.findFragmentByTag(tag)!!)
        .commit()
}

internal fun FragmentManager.addFragment(containerViewId: Int,
                                         fragment: Fragment,
                                         tag: String
                                        ) {
    this.beginTransaction()
        .add(containerViewId, fragment, tag)
        .commit()
}
