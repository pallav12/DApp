package com.dapp.dapp.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.dapp.dapp.MainApplication
import com.dapp.dapp.R
import com.dapp.dapp.helper.PrefManager

class GroupListFragment : Fragment() {

    lateinit var textView: TextView
    lateinit var button:Button
    lateinit var ll: LinearLayout
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
        ll = view.findViewById(R.id.ll)
        setView()
        button=view.findViewById(R.id.yo)
        button.setOnClickListener{
            viewModel.sendYo()
        }
        return view
    }
    fun setView(){
        Toast.makeText(context,"Cicked",Toast.LENGTH_LONG).show()
        ll.removeAllViews()
        Log.d("hello"+MainApplication.blockChain.blockChain.size,"world")
        for (elements in MainApplication.blockChain.blockChain){
            ll.addView(setUpLinearLayout(elements.previousHash,elements.message,elements.from,elements.currentHash.toString()))
        }
    }

    private fun setUpLinearLayout(
        previousStr: String,
        messageStr: String,
        fromStr: String,
        nextStr: String
    ): View {
        val layoutInflater = LayoutInflater.from(context).inflate(R.layout.item_block, null)
        val previous: TextView = layoutInflater.findViewById(R.id.preHash)
        val message: TextView = layoutInflater.findViewById(R.id.mesage)
        val from: TextView = layoutInflater.findViewById(R.id.from)
        val next: TextView = layoutInflater.findViewById(R.id.nextHash)
        previous.setText(previousStr)
        next.setText(nextStr)
        message.setText(messageStr)
        from.setText(fromStr)

        return layoutInflater


    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(GroupListViewModel::class.java)
        MainApplication.currentHash.observe(this, Observer {
            PrefManager.saveString("hash",it)
            textView.setText(it)
            setView()
        })
    }
}
