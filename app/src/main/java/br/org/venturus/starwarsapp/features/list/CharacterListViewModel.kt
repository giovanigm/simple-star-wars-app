package br.org.venturus.starwarsapp.features.list

import br.org.venturus.domain.characters.CharactersInteractor
import br.org.venturus.starwarsapp.features.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CharacterListViewModel(
    private val charactersInteractor: CharactersInteractor
): BaseViewModel<CharacterListViewState>() {

    fun loadCharacters() {
        val disposable = charactersInteractor.getCharactersList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { viewState.postValue(CharacterListViewState(isLoading = true)) }
            .doOnEvent { _, _ -> viewState.postValue(CharacterListViewState(isLoading = false)) }
            .subscribe (
                { result -> viewState.postValue(CharacterListViewState(charactersList = result)) },
                { error -> }
            )

        disposableContainer.add(disposable)
    }

}