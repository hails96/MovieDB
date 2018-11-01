package lsh.framgia.com.moviedb.screen.genredetail

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import lsh.framgia.com.moviedb.BR
import lsh.framgia.com.moviedb.R
import lsh.framgia.com.moviedb.base.BaseFragment
import lsh.framgia.com.moviedb.data.model.Genre
import lsh.framgia.com.moviedb.databinding.FragmentGenreDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class GenreDetailFragment : BaseFragment<FragmentGenreDetailBinding, GenreDetailViewModel>() {

    companion object {
        const val GENRE = "genre"
        fun newInstance(genre: Genre) = GenreDetailFragment().apply {
            arguments = Bundle().apply {
                putParcelable(GENRE, genre)
            }
        }
    }

    override val bindingVariable: Int = BR.genreDetailViewModel
    override val viewModel: GenreDetailViewModel by viewModel()
    override val layoutId: Int = R.layout.fragment_genre_detail
    private lateinit var movieAdapter: MovieAdapter

    override fun initComponent() {
        val genre = arguments?.getParcelable<Genre>(GENRE) ?: return
        setupMovieRecycler()
        setupObservers()
        showProgress()
        viewModel.getMoviesByGenre(genre.id)
    }

    private fun setupMovieRecycler() {
        movieAdapter = MovieAdapter(onMovieClick = { movie ->
            // TODO: on movie click
        })
        viewBinding.recyclerMovie.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = movieAdapter
        }
    }

    private fun setupObservers() {
        viewModel.apply {
            movies.observe(this@GenreDetailFragment, Observer { movies ->
                hideProgress()
                movieAdapter.submitList(movies)
            })
            error.observe(this@GenreDetailFragment, Observer {
                hideProgress()
                Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
            })
        }
    }
}
