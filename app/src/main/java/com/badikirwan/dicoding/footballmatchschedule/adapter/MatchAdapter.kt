package com.badikirwan.dicoding.footballmatchschedule.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.badikirwan.dicoding.footballmatchschedule.R
import com.badikirwan.dicoding.footballmatchschedule.model.model.events.Event
import com.badikirwan.dicoding.footballmatchschedule.utils.Utils
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.match_item.*

class MatchAdapter(private val items: List<Event>, private val listener:(Event) -> Unit)
    : RecyclerView.Adapter<MatchAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(
        R.layout.match_item, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    class ViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bindItem(items: Event, listener: (Event) -> Unit) {
            match_item_date.text = Utils.getFormatDate(items.dateEvent)
            match_item_home.text = items.strHomeTeam
            match_item_away.text = items.strAwayTeam
            match_item_home_score.text = items.intHomeScore
            match_item_away_score.text = items.intAwayScore

            containerView.setOnClickListener {
                listener(items)
            }
        }
    }
}