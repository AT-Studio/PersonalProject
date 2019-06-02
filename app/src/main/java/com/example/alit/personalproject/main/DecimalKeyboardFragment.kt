package com.example.alit.personalproject.main

import Base.BaseFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.alit.personalproject.R

class DecimalKeyboardFragment : BaseFragment() {

    companion object {

        const val DECIMAL_FRAGMENT_TAG = "decimalFrag"

        fun create(): DecimalKeyboardFragment {
            return DecimalKeyboardFragment()
        }

    }

    lateinit var rootView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_main_decimal, container, false)
        return rootView
    }

}