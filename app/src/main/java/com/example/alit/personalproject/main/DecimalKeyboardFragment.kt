package com.example.alit.personalproject.main

import Base.BaseFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.alit.personalproject.R
import kotlinx.android.synthetic.main.fragment_main_decimal.view.*

class DecimalKeyboardFragment : BaseFragment() {

    companion object {

        const val DECIMAL_FRAGMENT_TAG = "decimalFrag"

        fun create(): DecimalKeyboardFragment {
            return DecimalKeyboardFragment()
        }

    }

    lateinit var rootView: View

    lateinit var listener: OnDecimalNumberClickListener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_main_decimal, container, false)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setClickListener(rootView.tv_fragment_main_decimal_0)
        setClickListener(rootView.tv_fragment_main_decimal_1)
        setClickListener(rootView.tv_fragment_main_decimal_2)
        setClickListener(rootView.tv_fragment_main_decimal_3)
        setClickListener(rootView.tv_fragment_main_decimal_4)
        setClickListener(rootView.tv_fragment_main_decimal_5)
        setClickListener(rootView.tv_fragment_main_decimal_6)
        setClickListener(rootView.tv_fragment_main_decimal_7)
        setClickListener(rootView.tv_fragment_main_decimal_8)
        setClickListener(rootView.tv_fragment_main_decimal_9)
    }

    fun setClickListener(tv: TextView) {
        tv.setOnClickListener {
            listener.onDecimalNumberClicked(tv.text.toString()[0])
        }
    }

    fun setOnDecimalNumberClickListener(listener: OnDecimalNumberClickListener) {
        this.listener = listener
    }

    interface OnDecimalNumberClickListener {
        fun onDecimalNumberClicked(decimalNumber: Char);
    }

}