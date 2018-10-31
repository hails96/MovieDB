package lsh.framgia.com.moviedb.data.source.remote.network

import io.reactivex.Single
import lsh.framgia.com.moviedb.data.source.remote.response.GenreResponse
import lsh.framgia.com.moviedb.data.source.remote.response.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("genre/movie/list")
    fun getMovieGenres(): Single<GenreResponse>

    @GET("discover/movie")
    fun getMoviesByGenre(
        @Query("with_genres") genreId: Int,
        @Query("page") page: Int
    ): Single<MovieResponse>
}
