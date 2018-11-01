package lsh.framgia.com.moviedb.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import lsh.framgia.com.moviedb.R

object BindAdapter {

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun loadArtworkImage(imageView: ImageView, image: String?) {
        Glide.with(imageView.context)
            .load(IMAGE_END_POINT + image)
            .apply(
                RequestOptions
                    .placeholderOf(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
            )
            .into(imageView)
    }
}
