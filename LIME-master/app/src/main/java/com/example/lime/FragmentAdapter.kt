package com.example.lime

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class FragmentAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> FragmentHome()
            1 -> FragmentChat()
            2 -> FragmentTime()
            3 -> FragmentNote()
            else -> FragmentWallet()
        }

    }

    override fun getCount(): Int {
        return 5
    }
}