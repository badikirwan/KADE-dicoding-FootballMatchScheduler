package com.badikirwan.dicoding.footballmatchschedule.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.badikirwan.dicoding.footballmatchschedule.fragment.LastMatchFragment
import com.badikirwan.dicoding.footballmatchschedule.fragment.NextMatchFragment

class FragmentAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    private val pages = listOf(
        LastMatchFragment(),
        NextMatchFragment()
    )

    override fun getItem(position: Int): Fragment {
        return pages[position]
    }

    override fun getCount(): Int {
        return pages.size
    }

    override fun getPageTitle(position: Int) : CharSequence? {
        return when(position) {
            0 -> "Last Match"
            1 -> "Next Match"
            else -> {
                "ghgh"
            }
        }
    }
}