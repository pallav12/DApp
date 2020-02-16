package com.dapp.dapp.helper

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.MutableLiveData
import com.dapp.dapp.home.GroupListFragment

object TransactionHelper {

    fun startFragment(id: Int, fragmentManager: FragmentManager) {
        fragmentManager.beginTransaction()
            .replace(id, GroupListFragment.newInstance())
            .addToBackStack(null)
            .commit()

    }
}