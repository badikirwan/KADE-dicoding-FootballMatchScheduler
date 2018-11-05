package com.badikirwan.dicoding.footballmatchschedule.model.model.teams

import com.badikirwan.dicoding.footballmatchschedule.model.model.events.Event
import com.google.gson.annotations.SerializedName

data class TeamResponse(
    @SerializedName("teams") val teams: List<Team>
)