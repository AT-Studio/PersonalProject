package com.example.alit.personalproject.main

import Base.BaseFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.alit.personalproject.R
import kotlinx.android.synthetic.main.fragment_main_binary.view.*

class BinaryKeyboardFragment : BaseFragment() {

    companion object {

        const val BINARY_FRAGMENT_TAG = "binaryFrag"

        fun create(): BinaryKeyboardFragment {
            return BinaryKeyboardFragment()
        }

    }

    lateinit var rootView: View

    lateinit var listener: OnBinaryNumberClickListener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_main_binary, container, false)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setClickListener(rootView.tv_fragment_main_binary_0)
        setClickListener(rootView.tv_fragment_main_binary_1)
    }

    fun setClickListener(tv: TextView) {
        tv.setOnClickListener {
            listener.onBinaryNumberClicked(tv.text.toString()[0])
        }
    }

    fun setOnBinaryNumberClickListener(listener: OnBinaryNumberClickListener) {
        this.listener = listener
    }

    interface OnBinaryNumberClickListener {
        fun onBinaryNumberClicked(binaryNumber: Char);
    }
}