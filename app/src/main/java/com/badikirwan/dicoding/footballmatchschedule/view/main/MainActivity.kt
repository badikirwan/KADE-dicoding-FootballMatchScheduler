package com.badikirwan.dicoding.footballmatchschedule.view.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.badikirwan.dicoding.footballmatchschedule.R
import com.badikirwan.dicoding.footballmatchschedule.adapter.FragmentAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewpager_main.adapter = FragmentAdapter(supportFragmentManager)
        tabs_main.setupWithViewPager(viewpager_main)

    }
}
