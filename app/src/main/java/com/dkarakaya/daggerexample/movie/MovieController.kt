package com.dkarakaya.daggerexample.movie

import com.airbnb.epoxy.EpoxyController
import com.dkarakaya.daggerexample.repository.Model

class MovieController : EpoxyController() {


    var movieDetails: List<Model.MovieDetail> = listOf()
        set(value) {
            field = value
            requestModelBuild()
        }

//    var deepLinkClickListener: (deepLink: String) -> Unit = { }

    override fun buildModels() {
        movieDetails.forEachIndexed { index, details ->
            movie {
                id(index)
                name(details.name)
                minutes(details.runtimeInMinutes.toString())
                budget(details.budgetInMillions.toString())
                revenue(details.boxOfficeRevenueInMillions.toString())
                nominations(details.academyAwardNominations.toString())
                wins(details.academyAwardWins.toString())
//                onClickListener(View.OnClickListener {
//                    deepLinkClickListener(deepLink.deepLink)
//                })
            }
        }
    }
}
