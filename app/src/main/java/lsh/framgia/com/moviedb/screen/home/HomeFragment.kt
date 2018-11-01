package lsh.framgia.com.moviedb.screen.home

import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import lsh.framgia.com.moviedb.BR
import lsh.framgia.com.moviedb.R
import lsh.framgia.com.moviedb.base.BaseFragment
import lsh.framgia.com.moviedb.data.model.Genre
import lsh.framgia.com.moviedb.databinding.FragmentHomeBinding
import lsh.framgia.com.moviedb.screen.genredetail.GenreDetailFragment
import lsh.framgia.com.moviedb.screen.main.MainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    companion object {
        const val NUMBER_OF_COLUMNS = 3
        fun newInstance() = HomeFragment()
    }

    override val bindingVariable: Int = BR.homeViewModel
    override val viewModel: HomeViewModel by viewModel()
    override val layoutId: Int = R.layout.fragment_home
    private lateinit var genreAdapter: GenreAdapter

    override fun initComponent() {
        setupGenreRecycler()
        setupObservers()
        showProgress()
        viewModel.getMovieGenres()
    }

    private fun setupGenreRecycler() {
        genreAdapter = GenreAdapter(onGenreClick = { genre ->
            goToGenreDetailScreen(genre)
        })
        viewBinding.recyclerGenre.apply {
            layoutManager = GridLayoutManager(context, NUMBER_OF_COLUMNS)
            adapter = genreAdapter
        }
    }

    private fun setupObservers() {
        viewModel.apply {
            genres.observe(this@HomeFragment, Observer { genres ->
                hideProgress()
                genreAdapter.submitList(genres)
            })
            error.observe(this@HomeFragment, Observer {
                hideProgress()
                Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
            })
        }
    }

    private fun goToGenreDetailScreen(genre: Genre) {
        activity?.apply {
            if (this is MainActivity) {
                replaceFragment(
                    GenreDetailFragment.newInstance(genre), R.id.frame_container,
                    GenreDetailFragment::class.java.simpleName, true
                )
            }
        }
    }
}
