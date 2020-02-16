package com.dapp.dapp.helper

import android.content.Context
import android.preference.PreferenceManager
import com.dapp.dapp.MainApplication

object PrefManager {
    private val preferences by lazy { PreferenceManager.getDefaultSharedPreferences(context) }

    private val context: Context
        get() = MainApplication.instance.applicationContext

    fun saveBoolean(prefKey: String, prefValue: Boolean) {
        preferences.edit().putBoolean(prefKey, prefValue).apply()
    }

    fun getBoolean(prefKey: String, defaultValue: Boolean): Boolean{
       return preferences.getBoolean(prefKey,defaultValue)
    }
}