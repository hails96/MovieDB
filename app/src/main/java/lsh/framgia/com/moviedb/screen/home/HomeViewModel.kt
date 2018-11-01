package lsh.framgia.com.moviedb.screen.home

import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import lsh.framgia.com.moviedb.base.BaseViewModel
import lsh.framgia.com.moviedb.data.model.Genre
import lsh.framgia.com.moviedb.data.repository.GenreRepository
import lsh.framgia.com.moviedb.data.source.remote.response.GenreResponse

class HomeViewModel(val genreRepositoty: GenreRepository) : BaseViewModel() {

    val genres = MutableLiveData<List<Genre>>()
    val error = MutableLiveData<Throwable>()

    fun getMovieGenres() {
        addDisposable(
            genreRepositoty.getMovieGenres()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    onLoadSuccess(it)
                }, {
                    onLoadFailed(it)
                })
        )
    }

    private fun onLoadSuccess(genreResponse: GenreResponse?) {
        genres.value = genreResponse?.genres
    }

    private fun onLoadFailed(throwable: Throwable?) {
        error.value = throwable
    }
}
