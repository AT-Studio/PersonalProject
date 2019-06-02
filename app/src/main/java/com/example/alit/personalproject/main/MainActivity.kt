package com.example.alit.personalproject.main

import Base.BaseActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.widget.LinearLayout
import com.example.alit.personalproject.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Number System Converter"

        vp_activity_main.adapter = KeyboardStatePagerAdapter(supportFragmentManager)

        vp_activity_main.post {
            val vpParams = vp_activity_main.layoutParams as LinearLayout.LayoutParams
            vpParams.height = vp_activity_main.width
            vp_activity_main.layoutParams = vpParams
        }
    }

    inner class KeyboardStatePagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

        val itemCount = 3;

        override fun getItem(position: Int): Fragment {
            if (position == 0) return DecimalKeyboardFragment.create()
            else if (position == 1) return BinaryKeyboardFragment.create()
            else return HexKeyboardFragment.create()
        }

        override fun getCount(): Int {
            return itemCount
        }

    }

}
