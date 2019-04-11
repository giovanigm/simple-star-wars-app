package br.org.venturus.starwarsapp.features.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel<STATE>: ViewModel() {

    public val viewState: MutableLiveData<STATE> = MutableLiveData()
    protected val disposableContainer = CompositeDisposable()

    open fun onAttach() {

    }

    override fun onCleared() {
        super.onCleared()
        disposableContainer.clear()
    }

    public fun currentViewState(): STATE = viewState.value!!

}
