package lsh.framgia.com.moviedb.data.source.local

import lsh.framgia.com.moviedb.data.source.GenreDataSource
import lsh.framgia.com.moviedb.data.source.remote.network.ApiService

class GenreLocalDataSource(private val api: ApiService) : GenreDataSource.LocalDataSource
