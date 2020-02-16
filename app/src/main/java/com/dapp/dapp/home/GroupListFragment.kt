package com.dapp.dapp.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.dapp.dapp.MainApplication
import com.dapp.dapp.R
import com.dapp.dapp.helper.PrefManager

class GroupListFragment : Fragment() {

    lateinit var textView: TextView
    lateinit var button:Button
    companion object {
        fun newInstance() = GroupListFragment()
    }

    private lateinit var viewModel: GroupListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        PrefManager.saveBoolean("first_time",false)
        val view: View = inflater.inflate(R.layout.group_list_fragment, container, false)
        textView = view.findViewById(R.id.hello)
        textView.setText(PrefManager.getString("hash", "first"))
        button=view.findViewById(R.id.yo)
        button.setOnClickListener{
            viewModel.sendYo()
        }
        return view
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(GroupListViewModel::class.java)
        MainApplication.currentHash.observe(this, Observer {
            textView.setText(it)
            PrefManager.saveString("hash",it)
        })
    }
}
