package com.badikirwan.dicoding.footballmatchschedule.model.model.events

import com.google.gson.annotations.SerializedName

data class EventResponse(
    @SerializedName("events") val events: List<Event>
)