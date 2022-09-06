package com.example.data.base.preferences

import android.content.SharedPreferences

abstract class BasePreferencesImpl(private val sharedPreferences: SharedPreferences) : BasePreferences {
    override fun putSting(key: String, value: String?) = sharedPreferences.edit().putString(key, value).apply()
    override fun getString(key: String): String? = sharedPreferences.getString(key, null)
    override fun putInt(key: String, value: Int) = sharedPreferences.edit().putInt(key, value).apply()
    override fun getInt(key: String): Int = sharedPreferences.getInt(key, 0)
    override fun removeValue(key: String) = sharedPreferences.edit().remove(key).apply()
    override fun clearData() = sharedPreferences.edit().clear().apply()
}