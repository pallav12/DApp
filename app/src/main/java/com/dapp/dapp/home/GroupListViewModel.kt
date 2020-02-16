package com.dapp.dapp.home

import androidx.lifecycle.ViewModel
import com.dapp.dapp.MainApplication
import com.dapp.dapp.blockHelper.Block
import com.dapp.dapp.helper.PrefManager

class GroupListViewModel : ViewModel() {
    val repository:ListRepository= ListRepository()
    fun sendYo() {
        val block = Block(MainApplication.currentHash.value.toString(), null, "Yo!", PrefManager.getString("phone","me"))
        block.currentHash=block.hashCode().toString()
        repository.sendYo(block)

    }
}
