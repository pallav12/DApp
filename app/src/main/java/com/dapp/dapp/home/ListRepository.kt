package com.dapp.dapp.home

import android.util.Log
import com.dapp.dapp.MainApplication
import com.dapp.dapp.blockHelper.Block
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class ListRepository {

    fun sendYo(block: Block) {
        val str=MainApplication.currentHash.value.toString()
        FirebaseDatabase.getInstance().reference
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {

                    for (snapshot in dataSnapshot.children) {
                        val string: String = snapshot.getValue().toString()
                        Log.d(string,str+"hello")
                        if (string.equals(str)) {
                            val myRef = FirebaseDatabase.getInstance().getReference(snapshot.key as String)
                            myRef.setValue(block.hashCode().toString())
                        }
                    }
                }
                override fun onCancelled(databaseError: DatabaseError) {}
            })
        MainApplication.currentHash.value=block.hashCode().toString()
    }
}