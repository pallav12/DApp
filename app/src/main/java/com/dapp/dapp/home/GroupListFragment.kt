package com.dapp.dapp.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders

import com.dapp.dapp.R
import com.dapp.dapp.helper.PrefManager

class GroupListFragment : Fragment() {

    companion object {
        fun newInstance() = GroupListFragment()
    }

    private lateinit var viewModel: GroupListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        PrefManager.saveBoolean("first_time",false)
        return inflater.inflate(R.layout.group_list_fragment, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(GroupListViewModel::class.java)
    }
}
