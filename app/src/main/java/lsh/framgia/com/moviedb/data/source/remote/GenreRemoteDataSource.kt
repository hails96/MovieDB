package lsh.framgia.com.moviedb.data.source.remote

import io.reactivex.Single
import lsh.framgia.com.moviedb.data.source.GenreDataSource
import lsh.framgia.com.moviedb.data.source.remote.network.ApiService
import lsh.framgia.com.moviedb.data.source.remote.response.GenreResponse

class GenreRemoteDataSource(private val apiService: ApiService) : GenreDataSource.RemoteDataSource {
    
    override fun getMovieGenres(): Single<GenreResponse> {
        return apiService.getMovieGenres()
    }
}
