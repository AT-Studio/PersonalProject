package com.example.alit.personalproject.main

import Base.BaseActivity
import Base.BaseFragment
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.util.Log
import android.widget.LinearLayout
import com.example.alit.personalproject.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), DecimalKeyboardFragment.OnDecimalNumberClickListener, BinaryKeyboardFragment.OnBinaryNumberClickListener,
    HexKeyboardFragment.OnHexNumberClickListener{

    companion object {
        const val DECIMAL = "Decimal"
        const val BINARY = "Binary"
        const val HEX = "Hex"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Number System Converter"

        tv_activity_main_input.setText("")
        tv_activity_main_result.setText("")

        vp_activity_main.adapter = KeyboardStatePagerAdapter(supportFragmentManager)

        rl_activity_main_content.post {
            val vpParams = vp_activity_main.layoutParams as LinearLayout.LayoutParams
            vpParams.height = vp_activity_main.width
            vp_activity_main.layoutParams = vpParams

//            val dashParams = fl_activity_main_dashboard.layoutParams as RelativeLayout.LayoutParams
//            Log.d("heights", "main content: ${rl_activity_main_content.height}")
//            Log.d("heights", "main content: ${ll_main_keyboard_wrapper.height}")
//            dashParams.height = rl_activity_main_content.height - (vpParams.height + getPixels(56))
//            fl_activity_main_dashboard.layoutParams = dashParams
        }

        vp_activity_main.addOnPageChangeListener(object: ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                tv_activity_main_in_number_system.setText((vp_activity_main.adapter as KeyboardStatePagerAdapter).getPageTitle(position))
                tv_activity_main_input.setText("")
                tv_activity_main_result.setText("")
            }
        })

        iv_activity_main_in_left.setOnClickListener {
            vp_activity_main.arrowScroll(ViewPager.FOCUS_LEFT)
        }

        iv_activity_main_in_right.setOnClickListener {
            vp_activity_main.arrowScroll(ViewPager.FOCUS_RIGHT)
        }

        iv_activity_main_out_left.setOnClickListener {
            val currentText = tv_activity_main_out_number_system.text.toString()
            when (currentText) {
                in DECIMAL -> tv_activity_main_out_number_system.setText(DECIMAL)
                in BINARY -> tv_activity_main_out_number_system.setText(DECIMAL)
                in HEX -> tv_activity_main_out_number_system.setText(BINARY)
            }
        }

        iv_activity_main_out_right.setOnClickListener {
            val currentText = tv_activity_main_out_number_system.text.toString()
            when (currentText) {
                in DECIMAL -> tv_activity_main_out_number_system.setText(BINARY)
                in BINARY -> tv_activity_main_out_number_system.setText(HEX)
                in HEX -> tv_activity_main_out_number_system.setText(HEX)
            }
        }
    }

    override fun onDecimalNumberClicked(decimalNumber: Char) {
        Log.d("keyboardNum", "decimal num: $decimalNumber")
        val numberIn = tv_activity_main_input.text.toString() + decimalNumber
        tv_activity_main_input.setText(numberIn)
        val resultNumberSystem = tv_activity_main_out_number_system.text.toString()
        //TODO: make sure number is not bigger than int
        when (resultNumberSystem) {
            in DECIMAL -> tv_activity_main_result.setText(numberIn)
            in BINARY -> tv_activity_main_result.setText(Integer.toBinaryString(Integer.parseInt(numberIn)))
            in HEX -> tv_activity_main_result.setText(Integer.toHexString(Integer.parseInt(numberIn)))
        }
    }

    override fun onBinaryNumberClicked(binaryNumber: Char) {
        Log.d("keyboardNum", "binary num: $binaryNumber")
        val numberIn = tv_activity_main_input.text.toString() + binaryNumber
        tv_activity_main_input.setText(numberIn)
    }

    override fun onHexNumberClicked(hexNumber: Char) {
        Log.d("keyboardNum", "hex num: $hexNumber")
        val numberIn = tv_activity_main_input.text.toString() + hexNumber
        tv_activity_main_input.setText(numberIn)
    }

    inner class KeyboardStatePagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

        val numberSystems = arrayOf(DECIMAL, BINARY, HEX)

        override fun getItem(position: Int): Fragment {
            val fragment: BaseFragment
            if (position == 0) {
                fragment = DecimalKeyboardFragment.create()
                fragment.setOnDecimalNumberClickListener(this@MainActivity)
            }
            else if (position == 1) {
                fragment = BinaryKeyboardFragment.create()
                fragment.setOnBinaryNumberClickListener(this@MainActivity)
            }
            else {
                fragment = HexKeyboardFragment.create()
                fragment.setOnHexNumberClickListener(this@MainActivity)
            }
            return fragment
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return numberSystems[position]
        }

        override fun getCount(): Int {
            return numberSystems.size
        }

    }

}
