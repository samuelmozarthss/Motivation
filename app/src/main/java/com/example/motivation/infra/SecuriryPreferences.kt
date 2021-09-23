package com.example.motivation.infra

import android.content.Context
import android.content.SharedPreferences

class SecuriryPreferences(val context: Context) {

    private val mSharedPreferences = context.getSharedPreferences("motivation", Context.MODE_PRIVATE)

    fun storeString(key: String, value: String) {
        mSharedPreferences.edit().putString(key, value).apply()
    }

    fun getString(key: String) {

    }
}