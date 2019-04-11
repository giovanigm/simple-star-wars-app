package br.org.venturus.starwarsapp.core.databinding

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class BindingHolder<out T : ViewDataBinding>(val binding: T) : RecyclerView.ViewHolder(binding.root)