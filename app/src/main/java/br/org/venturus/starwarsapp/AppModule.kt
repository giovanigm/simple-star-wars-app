package br.org.venturus.starwarsapp

import br.org.venturus.starwarsapp.features.list.CharacterListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val applicationModule = module {

    viewModel { CharacterListViewModel(get()) }

}