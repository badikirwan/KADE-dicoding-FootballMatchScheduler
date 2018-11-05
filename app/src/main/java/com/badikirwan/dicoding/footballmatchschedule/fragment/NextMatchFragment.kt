package com.badikirwan.dicoding.footballmatchschedule.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar

import com.badikirwan.dicoding.footballmatchschedule.R
import com.badikirwan.dicoding.footballmatchschedule.adapter.MatchAdapter
import com.badikirwan.dicoding.footballmatchschedule.api.APIClient
import com.badikirwan.dicoding.footballmatchschedule.model.model.events.EventResponse
import com.badikirwan.dicoding.footballmatchschedule.view.detail.DetailActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 *
 */
class NextMatchFragment : Fragment() {

    private var LEAGUE_ID: String? = "4328"
    private lateinit var layout: View
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressLoading: ProgressBar

    private fun setLoading() {
        progressLoading.visibility = View.VISIBLE
        recyclerView.visibility = View.INVISIBLE
    }

    fun hideLoading() {
        progressLoading.visibility = View.GONE
        recyclerView.visibility = View.VISIBLE
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        layout = inflater.inflate(R.layout.fragment_next_match, container, false)
        recyclerView = layout.findViewById(R.id.recycle_next_match)
        progressLoading = layout.findViewById(R.id.prog_next_match)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        setLoading()
        loadData()
        return layout
    }

    fun loadData() {
        val apiInterface = APIClient.create()

        apiInterface.getNextMatch(LEAGUE_ID).enqueue(object : Callback<EventResponse> {

            override fun onFailure(call: Call<EventResponse>, t: Throwable) {
                Log.e("Errornya :", "${t.message}")
                hideLoading()
            }

            override fun onResponse(call: Call<EventResponse>, response: Response<EventResponse>) {
                if (response.isSuccessful) {
                    val data = response.body()?.events
                    recyclerView.adapter = MatchAdapter(data!!) {
                       event -> startActivity(context?.let { DetailActivity.newIntent(it, event) })
                    }
                }
                hideLoading()
            }

        })
    }


}
