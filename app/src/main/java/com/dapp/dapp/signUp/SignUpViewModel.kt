package com.dapp.dapp.signUp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dapp.dapp.MainApplication
import com.dapp.dapp.blockHelper.Block

class SignUpViewModel : ViewModel() {

    var response = MutableLiveData<Boolean>()
    private var signUpRepository=SignUpRepository(MainApplication.instance)
    fun signUp(phone:String){
        val block=Block("1st",null,"Yo",phone)
        block.currentHash=block.hashCode().toString()
        signUpRepository.signUp(phone,block,response)
    }
}
