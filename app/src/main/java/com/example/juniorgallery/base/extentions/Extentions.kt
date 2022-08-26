package com.example.juniorgallery.base.extentions

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.core.content.ContextCompat

fun EditText.onTextChanged(onTextChanged: (String) -> Unit) =
    addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) =
            onTextChanged.invoke(p0.toString())

        override fun afterTextChanged(editable: Editable?) {}
    })

fun Int.getColor(context: Context): Int = ContextCompat.getColor(context, this)