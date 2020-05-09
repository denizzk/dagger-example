package com.dkarakaya.core.repository

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

object Model {
    data class Book(
        @SerializedName("docs")
        @Expose
        val bookDetails: List<BookDetail>
    )

    class BookDetail(
        @SerializedName("_id")
        @Expose
        val id: String,
        @SerializedName("name")
        @Expose
        val name: String
    )

    data class Movie(
        @SerializedName("docs")
        @Expose
        val movieDetails: List<MovieDetail>
    )

    data class MovieDetail(
        @SerializedName("_id")
        @Expose
        val id: String,
        @SerializedName("name")
        @Expose
        val name: String,
        @SerializedName("runtimeInMinutes")
        @Expose
        val runtimeInMinutes: Int,
        @SerializedName("budgetInMillions")
        @Expose
        val budgetInMillions: Double,
        @SerializedName("boxOfficeRevenueInMillions")
        @Expose
        val boxOfficeRevenueInMillions: Double,
        @SerializedName("academyAwardNominations")
        @Expose
        val academyAwardNominations: Int,
        @SerializedName("academyAwardWins")
        @Expose
        val academyAwardWins: Int
    )

    data class Character(
        @SerializedName("docs")
        @Expose
        val characterDetails: List<CharacterDetail>
    )

    data class CharacterDetail(
        @SerializedName("_id")
        @Expose
        val id: String?,
        @SerializedName("height")
        @Expose
        val height: String?,
        @SerializedName("race")
        @Expose
        val race: String,
        @SerializedName("gender")
        @Expose
        val gender: String?,
        @SerializedName("birth")
        @Expose
        val birth: String?,
        @SerializedName("spouse")
        @Expose
        val spouse: String?,
        @SerializedName("death")
        @Expose
        val death: String?,
        @SerializedName("realm")
        @Expose
        val realm: String?,
        @SerializedName("hair")
        @Expose
        val hair: String?,
        @SerializedName("name")
        @Expose
        val name: String,
        @SerializedName("wikiUrl")
        @Expose
        val wikiUrl: String
    )

}
