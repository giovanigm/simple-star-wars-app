package br.org.venturus.starwarsapp.features.detail

import br.org.venturus.domain.characters.CharacterEntity

data class CharacterDetailViewState(
    val character: CharacterEntity? = null
)