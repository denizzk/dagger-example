package com.dkarakaya.daggerexample.movie

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.dkarakaya.daggerexample.R

@EpoxyModelClass(layout = R.layout.item_movie)
abstract class MovieModel : EpoxyModelWithHolder<MovieModel.MovieHolder>() {

    @EpoxyAttribute
    var name: String? = null

    @EpoxyAttribute
    lateinit var minutes: String

    @EpoxyAttribute
    lateinit var budget: String

    @EpoxyAttribute
    lateinit var revenue: String

    @EpoxyAttribute
    lateinit var nominations: String

    @EpoxyAttribute
    lateinit var wins: String

    override fun bind(holder: MovieHolder) {
        holder.name.text = name
        holder.minutes.text = minutes
        holder.budget.text = budget
        holder.revenue.text = revenue
        holder.nominations.text = nominations
        holder.wins.text = wins
    }

    inner class MovieHolder : EpoxyHolder() {

        lateinit var name: TextView
        lateinit var minutes: TextView
        lateinit var budget: TextView
        lateinit var revenue: TextView
        lateinit var nominations: TextView
        lateinit var wins: TextView

        override fun bindView(itemView: View) {
            name = itemView.findViewById(R.id.name_value)
            minutes = itemView.findViewById(R.id.minutes_value)
            budget = itemView.findViewById(R.id.budget_value)
            revenue = itemView.findViewById(R.id.revenue_value)
            nominations = itemView.findViewById(R.id.award_nominations_value)
            wins = itemView.findViewById(R.id.award_wins_value)
        }

    }
}


