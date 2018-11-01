package lsh.framgia.com.moviedb.screen.genredetail

import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import lsh.framgia.com.moviedb.base.BaseViewModel
import lsh.framgia.com.moviedb.data.model.Movie
import lsh.framgia.com.moviedb.data.repository.MovieRepository
import lsh.framgia.com.moviedb.data.source.remote.response.MovieResponse

class GenreDetailViewModel(val movieRepository: MovieRepository) : BaseViewModel() {

    val movies = MutableLiveData<List<Movie>>()
    val error = MutableLiveData<Throwable>()
    val currentPage = 1

    fun getMoviesByGenre(genreId: Int) {
        addDisposable(
            movieRepository.getMoviesByGenre(genreId, currentPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    onLoadSuccess(it)
                }, {
                    onLoadFailed(it)
                })
        )
    }

    private fun onLoadSuccess(genreResponse: MovieResponse?) {
        movies.value = genreResponse?.movies
    }

    private fun onLoadFailed(throwable: Throwable?) {
        error.value = throwable
    }
}
