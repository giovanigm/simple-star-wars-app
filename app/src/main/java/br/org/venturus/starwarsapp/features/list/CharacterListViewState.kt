package br.org.venturus.starwarsapp.features.list

import br.org.venturus.domain.characters.CharacterEntity

data class CharacterListViewState(
    val charactersList: List<CharacterEntity> = listOf(),
    val isLoading: Boolean = false
)