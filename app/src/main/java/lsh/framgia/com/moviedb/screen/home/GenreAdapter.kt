package lsh.framgia.com.moviedb.screen.home

import androidx.recyclerview.widget.DiffUtil
import lsh.framgia.com.moviedb.R
import lsh.framgia.com.moviedb.base.BaseRecyclerViewAdapter
import lsh.framgia.com.moviedb.data.model.Genre
import lsh.framgia.com.moviedb.databinding.ItemGenreBinding

class GenreAdapter(val onGenreClick: (Genre) -> Unit) :
        BaseRecyclerViewAdapter<Genre, ItemGenreBinding>(
                object : DiffUtil.ItemCallback<Genre>() {
                    override fun areContentsTheSame(oldItem: Genre, newItem: Genre): Boolean {
                        return oldItem.name.equals(newItem.name)
                    }

                    override fun areItemsTheSame(oldItem: Genre, newItem: Genre): Boolean {
                        return oldItem.id == newItem.id
                    }
                }) {

    override fun getLayoutId(): Int = R.layout.item_genre

    override fun bindData(binding: ItemGenreBinding, item: Genre) {
        binding.genre = item
    }

    override fun onItemClick(viewBinding: ItemGenreBinding) {
        viewBinding.genre?.let {
            onGenreClick.invoke(it)
        }
    }
}
