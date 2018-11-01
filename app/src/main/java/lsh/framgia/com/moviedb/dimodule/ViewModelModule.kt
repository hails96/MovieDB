package lsh.framgia.com.moviedb.dimodule

import lsh.framgia.com.moviedb.screen.genredetail.GenreDetailViewModel
import lsh.framgia.com.moviedb.screen.home.HomeViewModel
import lsh.framgia.com.moviedb.screen.main.MainViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module(override = true) {
    viewModel { MainViewModel() }
    viewModel { HomeViewModel(get()) }
    viewModel { GenreDetailViewModel(get()) }
}
