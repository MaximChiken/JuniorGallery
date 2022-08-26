package com.example.juniorgallery.customview

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.example.juniorgallery.R
import com.example.juniorgallery.base.extentions.onTextChanged
import com.example.juniorgallery.databinding.CustomAppbarBinding
import com.google.android.material.textfield.TextInputLayout.END_ICON_CUSTOM
import com.google.android.material.textfield.TextInputLayout.END_ICON_NONE

class CustomAppBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0,
) : ConstraintLayout(context, attrs, defStyleAttr, defStyleRes) {

    var callback: ((AppBarButtons) -> Unit)? = null
    var searchText: String
        get() = binding.etSearch.text.toString()
        set(value) {
            with(binding) {
                etSearch.setText(value)
            }
        }

    private var appBarType: Int = AppBarTypes.TYPE_CANCEL.ordinal
        set(value) {
            field = value
            updateType()
        }

    var appBarEndIcon: Drawable? = null
        set(value) {
            field = value
            updateEndIcon(value)
        }

    private val binding = CustomAppbarBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.CustomAppBar,
            defStyleAttr,
            defStyleRes
        ).apply {
            try {
                appBarType = getInt(R.styleable.CustomAppBar_app_bar_type, 0)
                appBarEndIcon = getDrawable(R.styleable.CustomAppBar_app_bar_end_icon)
            } finally {
                recycle()
            }
        }
    }

    private fun updateType() {
        with(binding) {
            root.loadLayoutDescription(R.xml.custom_appbar_state)
            when (appBarType) {
                AppBarTypes.TYPE_BACK.ordinal -> {
                    root.setState(R.id.appbarBackState, 0, 0)
                    setBackType()
                }
                AppBarTypes.TYPE_SEARCH.ordinal -> {
                    root.setState(R.id.appbarSearchState, 0, 0)
                    setSearchType()
                }
                AppBarTypes.TYPE_CANCEL.ordinal -> {
                    root.setState(R.id.appbarCancelState, 0, 0)
                    setCancelType()
                }
            }
        }
    }

    private fun updateEndIcon(icon: Drawable?) {
        with(binding) {
            ivEndIcon.isVisible = icon != null
            ivEndIcon.setImageDrawable(icon)
        }
    }


    private fun setSearchType() {
        with(binding) {
            etSearch.onTextChanged {
                tilSearch.endIconMode = if (searchText.isNotEmpty()) END_ICON_CUSTOM else END_ICON_NONE
                tilSearch.setEndIconOnClickListener {
                    callback?.invoke(AppBarButtons.BUTTON_CROSS)
                    searchText = ""
                }
            }
            tilSearch.setStartIconOnClickListener {
                if (searchText.isNotEmpty()) {
                    clearFocus()
                    callback?.invoke(AppBarButtons.BUTTON_SEARCH)
                }
            }
            etSearch.setOnKeyListener { _, keyCode, _ ->
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    if (searchText.isNotEmpty()) {
                        clearFocus()
                        callback?.invoke(AppBarButtons.BUTTON_SEARCH)
                    }
                    true
                } else {
                    false
                }
            }
        }
    }

    private fun setBackType() {
        with(binding) {
            ivBack.setOnClickListener {
                callback?.invoke(AppBarButtons.BUTTON_BACK)
            }
            ivEndIcon.setOnClickListener {
                callback?.invoke(AppBarButtons.BUTTON_ACTION)
            }
        }
    }

    private fun setCancelType() {
        with(binding) {
            tvCencel.setOnClickListener {
                callback?.invoke(AppBarButtons.BUTTON_CANCEL)
            }
            ivEndIcon.setOnClickListener {
                callback?.invoke(AppBarButtons.BUTTON_ACTION)
            }
        }
    }

    enum class AppBarTypes {
        TYPE_BACK,
        TYPE_SEARCH,
        TYPE_CANCEL
    }

    enum class AppBarButtons {
        BUTTON_ACTION,
        BUTTON_SEARCH,
        BUTTON_CROSS,
        BUTTON_CANCEL,
        BUTTON_BACK,
    }
}