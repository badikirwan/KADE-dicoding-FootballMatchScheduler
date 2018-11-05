package com.badikirwan.dicoding.footballmatchschedule.view.detail

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.badikirwan.dicoding.footballmatchschedule.R
import com.badikirwan.dicoding.footballmatchschedule.api.APIClient
import com.badikirwan.dicoding.footballmatchschedule.model.model.events.Event
import com.badikirwan.dicoding.footballmatchschedule.model.model.teams.TeamResponse
import com.badikirwan.dicoding.footballmatchschedule.utils.Utils
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {

    private lateinit var event: Event
    val apiInterface = APIClient.create()

    companion object {

        private val INTENT_EVENT = "event"

        fun newIntent(context: Context, event: Event) : Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(INTENT_EVENT, event)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = resources.getString(R.string.match_detail)

        val intent = intent
        event = intent.extras?.getParcelable(INTENT_EVENT)!!

        detail_match_home.text = event.strHomeTeam
        detail_match_away.text = event.strAwayTeam
        detail_match_date.text = Utils.getFormatDate(event.dateEvent)
        detail_match_home_score.text = event.intHomeScore
        detail_match_away_score.text = event.intAwayScore
        detail_match_home_shots.text = event.intHomeShots
        detail_match_away_shots.text = event.intAwayShots
        detail_match_home_goals.text = event.strHomeGoalDetails
        detail_match_away_goals.text = event.strAwayGoalDetails
        detail_match_home_goal_keeper.text = event.strHomeLineupGoalkeeper
        detail_match_away_goal_keeper.text = event.strAwayLineupGoalkeeper
        detail_match_home_defense.text = event.strHomeLineupDefense
        detail_match_away_defense.text = event.strAwayLineupDefense
        detail_match_home_midfield.text = event.strHomeLineupMidfield
        detail_match_away_midfield.text = event.strAwayLineupMidfield
        detail_match_home_forward.text = event.strHomeLineupForward
        detail_match_away_forward.text = event.strAwayLineupForward
        detail_match_home_substitutes.text = event.strHomeLineupSubstitutes
        detail_match_away_substitutes.text = event.strAwayLineupSubstitutes

        getImageHomeTeam()
        getImageAwayTeam()

    }

    fun getImageHomeTeam() {
        apiInterface.getImageTeam(event.idHomeTeam).enqueue(object : Callback<TeamResponse> {

            override fun onFailure(call: Call<TeamResponse>, t: Throwable) {
                Log.e("Errornya :", "${t.message}")
            }

            override fun onResponse(call: Call<TeamResponse>, response: Response<TeamResponse>) {
                if (response.isSuccessful) {
                    Glide.with(this@DetailActivity)
                        .load(response.body()?.teams!![0].strTeamBadge)
                        .into(detail_match_home_badge)
                }
            }

        })
    }

    fun getImageAwayTeam() {
        apiInterface.getImageTeam(event.idAwayTeam).enqueue(object : Callback<TeamResponse> {

            override fun onFailure(call: Call<TeamResponse>, t: Throwable) {
                Log.e("Errornya :", "${t.message}")
            }

            override fun onResponse(call: Call<TeamResponse>, response: Response<TeamResponse>) {
                if (response.isSuccessful) {
                    Glide.with(this@DetailActivity)
                        .load(response.body()?.teams!![0].strTeamBadge)
                        .into(detail_match_away_badge)
                }
            }

        })
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId

        if (id == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
