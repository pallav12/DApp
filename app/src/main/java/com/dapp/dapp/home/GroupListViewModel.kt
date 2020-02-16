package com.dapp.dapp.home

import androidx.lifecycle.ViewModel
import com.dapp.dapp.MainApplication
import com.dapp.dapp.blockHelper.Block

class GroupListViewModel : ViewModel() {
    val repository:ListRepository= ListRepository()
    fun sendYo() {
        val block = Block(MainApplication.currentHash.value.toString(), null, "Yo!", "Myself")
        repository.sendYo(block)

    }
}
