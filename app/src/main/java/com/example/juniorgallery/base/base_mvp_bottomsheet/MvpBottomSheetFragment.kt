package com.example.juniorgallery.base.base_mvp_bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import moxy.MvpDelegate
import moxy.MvpDelegateHolder

abstract class MvpBottomSheetFragment<VB : ViewBinding, P : MvpBottomSheetPresenter<*>> : BottomSheetDialogFragment(),
    MvpBottomSheetView, MvpDelegateHolder {

    abstract val presenter: P

    private var _binding: VB? = null
    val binding: VB
        get() = _binding as VB

    private var mIsStateSaved = false

    private var mvpDelegate: MvpDelegate<out MvpBottomSheetFragment<*, *>>? = null


    abstract fun initializeBinding(): VB

    open fun setUpListeners() = Unit

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getMvpDelegate()?.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = initializeBinding()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListeners()
    }

    @CallSuper
    override fun onResume() {
        super.onResume()
        mIsStateSaved = false
        getMvpDelegate()?.onAttach()
    }

    @CallSuper
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mIsStateSaved = true
        getMvpDelegate()?.onSaveInstanceState(outState)
        getMvpDelegate()?.onDetach()
    }

    @CallSuper
    override fun onStop() {
        super.onStop()
        getMvpDelegate()?.onDetach()
    }

    @CallSuper
    override fun onDestroyView() {
        super.onDestroyView()
        getMvpDelegate()?.onDetach()
        getMvpDelegate()?.onDestroyView()
    }

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        if (requireActivity().isFinishing) {
            getMvpDelegate()?.onDestroy()
            return
        }

        if (mIsStateSaved) {
            mIsStateSaved = false
            return
        }

        var anyParentIsRemoving = false
        var parent = parentFragment
        while (!anyParentIsRemoving && parent != null) {
            anyParentIsRemoving = parent.isRemoving
            parent = parent.parentFragment
        }
        if (isRemoving || anyParentIsRemoving) {
            getMvpDelegate()?.onDestroy()
        }
    }

    override fun getMvpDelegate(): MvpDelegate<*>? {
        if (mvpDelegate == null) {
            mvpDelegate = MvpDelegate<MvpBottomSheetFragment<*, *>>(this)
        }
        return mvpDelegate
    }
}