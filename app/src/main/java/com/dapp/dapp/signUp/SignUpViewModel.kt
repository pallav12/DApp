package com.dapp.dapp.signUp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dapp.dapp.MainApplication

class SignUpViewModel : ViewModel() {

    var response = MutableLiveData<Boolean>()
    private var signUpRepository=SignUpRepository(MainApplication.instance)
    fun signUp(phone:String){
        signUpRepository.signUp(phone,response)
    }
}
