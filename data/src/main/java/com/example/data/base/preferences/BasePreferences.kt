package com.example.data.base.preferences

interface BasePreferences {
    fun putSting(key: String, value: String?)
    fun getString(key: String): String?
    fun putInt(key: String, value: Int)
    fun getInt(key: String): Int
    fun removeValue(key: String)
    fun clearData()
}