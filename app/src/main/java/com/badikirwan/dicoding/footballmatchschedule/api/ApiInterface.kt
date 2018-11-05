package com.badikirwan.dicoding.footballmatchschedule.api

import com.badikirwan.dicoding.footballmatchschedule.model.model.events.EventResponse
import com.badikirwan.dicoding.footballmatchschedule.model.model.teams.TeamResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("eventsnextleague.php")
    fun getNextMatch(@Query("id") id: String?): Call<EventResponse>

    @GET("eventspastleague.php")
    fun getPastMatch(@Query("id") id: String?): Call<EventResponse>

    @GET("lookupteam.php")
    fun getImageTeam(@Query("id") id: String?): Call<TeamResponse>
}