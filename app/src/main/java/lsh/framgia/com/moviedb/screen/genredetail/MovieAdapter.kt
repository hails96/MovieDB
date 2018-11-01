package lsh.framgia.com.moviedb.screen.genredetail

import androidx.recyclerview.widget.DiffUtil
import lsh.framgia.com.moviedb.R
import lsh.framgia.com.moviedb.base.BaseRecyclerViewAdapter
import lsh.framgia.com.moviedb.data.model.Movie
import lsh.framgia.com.moviedb.databinding.ItemMovieBinding

class MovieAdapter(val onMovieClick: (Movie) -> Unit) :
    BaseRecyclerViewAdapter<Movie, ItemMovieBinding>(
        object : DiffUtil.ItemCallback<Movie>() {
            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.title.equals(newItem.title)
            }

            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.id == newItem.id
            }
        }) {

    override fun getLayoutId(): Int = R.layout.item_movie

    override fun bindData(binding: ItemMovieBinding, item: Movie) {
        binding.movie = item
    }

    override fun onItemClick(viewBinding: ItemMovieBinding) {
        viewBinding.movie?.let {
            onMovieClick.invoke(it)
        }
    }
}
