package com.example.alit.personalproject.main

import Base.BaseFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.alit.personalproject.R
import kotlinx.android.synthetic.main.fragment_main_hex.view.*

class HexKeyboardFragment : BaseFragment() {

    companion object {

        const val HEX_FRAGMENT_TAG = "hexFrag"

        fun create(): HexKeyboardFragment {
            return HexKeyboardFragment()
        }

    }

    lateinit var rootView: View

    lateinit var listener: OnHexNumberClickListener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_main_hex, container, false)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setClickListener(rootView.tv_fragment_main_hex_0)
        setClickListener(rootView.tv_fragment_main_hex_1)
        setClickListener(rootView.tv_fragment_main_hex_2)
        setClickListener(rootView.tv_fragment_main_hex_3)
        setClickListener(rootView.tv_fragment_main_hex_4)
        setClickListener(rootView.tv_fragment_main_hex_5)
        setClickListener(rootView.tv_fragment_main_hex_6)
        setClickListener(rootView.tv_fragment_main_hex_7)
        setClickListener(rootView.tv_fragment_main_hex_8)
        setClickListener(rootView.tv_fragment_main_hex_9)
        setClickListener(rootView.tv_fragment_main_hex_A)
        setClickListener(rootView.tv_fragment_main_hex_B)
        setClickListener(rootView.tv_fragment_main_hex_C)
        setClickListener(rootView.tv_fragment_main_hex_D)
        setClickListener(rootView.tv_fragment_main_hex_E)
        setClickListener(rootView.tv_fragment_main_hex_F)
    }

    fun setClickListener(tv: TextView) {
        tv.setOnClickListener {
            listener.onHexNumberClicked(tv.text.toString()[0])
        }
    }

    fun setOnHexNumberClickListener(listener: OnHexNumberClickListener) {
        this.listener = listener
    }

    interface OnHexNumberClickListener {
        fun onHexNumberClicked(hexNumber: Char);
    }

}