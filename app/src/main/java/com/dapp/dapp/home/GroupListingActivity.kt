package com.dapp.dapp.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.dapp.dapp.R
import com.dapp.dapp.helper.TransactionHelper

class GroupListingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_listing)
        TransactionHelper.startFragment(R.id.fragment_container,supportFragmentManager)
    }
}
