package lsh.framgia.com.moviedb.dimodule

import lsh.framgia.com.moviedb.data.repository.GenreRepository
import lsh.framgia.com.moviedb.data.source.GenreDataSource
import lsh.framgia.com.moviedb.data.source.local.GenreLocalDataSource
import lsh.framgia.com.moviedb.data.source.remote.GenreRemoteDataSource
import lsh.framgia.com.moviedb.data.source.remote.network.ApiService
import org.koin.dsl.module.module

val repositoryModule = module(override = true) {
    single { createGenreRemoteDataSource(get()) }
    single { createGenreLocalDataSource() }
    single { createGenreRepository(get(), get()) }
}

fun createGenreRemoteDataSource(
    apiService: ApiService
): GenreDataSource.RemoteDataSource = GenreRemoteDataSource(apiService)

fun createGenreLocalDataSource(): GenreDataSource.LocalDataSource = GenreLocalDataSource()

fun createGenreRepository(
    local: GenreDataSource.LocalDataSource, remote: GenreDataSource.RemoteDataSource
): GenreRepository = GenreRepository(local, remote)
