package br.org.venturus.starwarsapp.core.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import br.org.venturus.starwarsapp.core.view.GlideApp
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade

@BindingAdapter("src")
fun setPictureUrl(imageView: ImageView, urlString: String?) = urlString?.let {
    GlideApp.with(imageView.context)
        .load(it)
        .transition(withCrossFade())
        .into(imageView)
}