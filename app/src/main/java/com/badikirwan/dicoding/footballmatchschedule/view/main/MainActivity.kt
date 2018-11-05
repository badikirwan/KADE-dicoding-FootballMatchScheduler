package com.badikirwan.dicoding.footballmatchschedule.view.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.badikirwan.dicoding.footballmatchschedule.R
import com.badikirwan.dicoding.footballmatchschedule.R.id.menu_last_match
import com.badikirwan.dicoding.footballmatchschedule.R.id.menu_next_match
import com.badikirwan.dicoding.footballmatchschedule.R.id.menu_favorite
import com.badikirwan.dicoding.footballmatchschedule.adapter.FragmentAdapter
import com.badikirwan.dicoding.footballmatchschedule.fragment.LastMatchFragment
import com.badikirwan.dicoding.footballmatchschedule.fragment.NextMatchFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //viewpager_main.adapter = FragmentAdapter(supportFragmentManager)
        //tabs_main.setupWithViewPager(viewpager_main)
        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                menu_last_match -> {
                    loadLastMatchFragment(savedInstanceState)
                }
                menu_next_match -> {
                    loadNextMatchFragment(savedInstanceState)
                }
                menu_favorite -> {

                }
            }
            true
        }

        bottom_navigation.selectedItemId = menu_last_match
    }

    private fun loadLastMatchFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, LastMatchFragment(), LastMatchFragment::class.java.simpleName)
                .commit()
        }
    }

    private fun loadNextMatchFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, NextMatchFragment(), NextMatchFragment::class.java.simpleName)
                .commit()
        }
    }
}
