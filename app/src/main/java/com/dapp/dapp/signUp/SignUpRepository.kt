package com.dapp.dapp.signUp

import android.app.Application
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dapp.dapp.helper.PrefManager
import com.google.firebase.database.FirebaseDatabase


class SignUpRepository(@NonNull val application: Application) {

    fun signUp(phone: String,liveData:MutableLiveData<Boolean>) {
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("message")
        myRef.setValue(phone)
        PrefManager.saveBoolean("sign_up",true)
        liveData.value=true
    }

}