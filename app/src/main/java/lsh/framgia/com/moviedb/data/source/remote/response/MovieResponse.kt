package lsh.framgia.com.moviedb.data.source.remote.response

import com.google.gson.annotations.SerializedName
import lsh.framgia.com.moviedb.data.model.Movie

data class MovieResponse(
    @SerializedName("results")
    val movies: List<Movie>
)
