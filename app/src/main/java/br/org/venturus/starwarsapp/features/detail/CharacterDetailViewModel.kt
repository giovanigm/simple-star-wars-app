package br.org.venturus.starwarsapp.features.detail

import br.org.venturus.domain.characters.CharactersInteractor
import br.org.venturus.starwarsapp.features.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CharacterDetailViewModel(
    private val charactersInteractor: CharactersInteractor
): BaseViewModel<CharacterDetailViewState>() {

    fun loadCharacter(characterId: Int) {
        val disposable = charactersInteractor.getCharacter(characterId)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe (
                { result -> viewState.postValue(CharacterDetailViewState(character = result)) },
                { error -> }
            )

        disposableContainer.add(disposable)
    }

}