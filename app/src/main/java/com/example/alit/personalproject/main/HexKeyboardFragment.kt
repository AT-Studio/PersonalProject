package com.example.alit.personalproject.main

import Base.BaseFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.alit.personalproject.R

class HexKeyboardFragment : BaseFragment() {

    companion object {

        const val HEX_FRAGMENT_TAG = "hexFrag"

        fun create(): HexKeyboardFragment {
            return HexKeyboardFragment()
        }

    }

    lateinit var rootView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_main_hex, container, false)
        return rootView
    }

}