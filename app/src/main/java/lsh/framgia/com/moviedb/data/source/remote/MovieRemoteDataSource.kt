package lsh.framgia.com.moviedb.data.source.remote

import io.reactivex.Single
import lsh.framgia.com.moviedb.data.source.MovieDataSource
import lsh.framgia.com.moviedb.data.source.remote.network.ApiService
import lsh.framgia.com.moviedb.data.source.remote.response.MovieResponse

class MovieRemoteDataSource(private val apiService: ApiService) : MovieDataSource.RemoteDataSource {

    override fun getMoviesByGenre(genreId: Int, page: Int): Single<MovieResponse> {
        return apiService.getMoviesByGenre(genreId, page)
    }
}
