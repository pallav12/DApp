package com.dapp.dapp.signUp

import android.app.Application
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.lifecycle.MutableLiveData
import com.dapp.dapp.MainApplication
import com.dapp.dapp.blockHelper.Block
import com.dapp.dapp.helper.HashCalculator
import com.dapp.dapp.helper.PrefManager
import com.google.firebase.database.FirebaseDatabase


class SignUpRepository(@NonNull val application: Application) {

    fun signUp(phone: String,block:Block,liveData:MutableLiveData<Boolean>) {
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference(phone)
        myRef.setValue(block.hashCode().toString()).addOnSuccessListener {
            MainApplication.currentHash.value = block.hashCode().toString()
            PrefManager.saveString("hash", block.hashCode().toString())
            liveData.value = true
        }
            .addOnFailureListener {
                Toast.makeText(
                    MainApplication.instance.applicationContext,
                    "Check your internet connection",
                    Toast.LENGTH_LONG
                ).show()

            }
        MainApplication.currentHash.value = block.hashCode().toString()
        MainApplication.blockChain.addBlock(block)
        liveData.value=true

    }

}