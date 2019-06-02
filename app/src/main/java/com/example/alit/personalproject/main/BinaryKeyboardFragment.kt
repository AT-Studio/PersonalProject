package com.example.alit.personalproject.main

import Base.BaseFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.alit.personalproject.R

class BinaryKeyboardFragment : BaseFragment() {

    companion object {

        const val BINARY_FRAGMENT_TAG = "binaryFrag"

        fun create(): BinaryKeyboardFragment {
            return BinaryKeyboardFragment()
        }

    }

    lateinit var rootView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_main_binary, container, false)
        return rootView
    }
}