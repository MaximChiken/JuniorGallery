package com.example.data.base.preferences

interface BasePreferences {
    fun putSting(key: String, value: String?)
    fun getString(key: String): String?
    fun removeValue(key: String)
    fun clearData()
}