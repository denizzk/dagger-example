package com.dkarakaya.character

import androidx.lifecycle.ViewModel
import com.dkarakaya.core.repository.LOTRApiService
import com.dkarakaya.core.repository.Model
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject

class CharacterViewModel : ViewModel() {

    private val disposable = CompositeDisposable()

    private val charactersSubject = BehaviorSubject.create<List<Model.CharacterDetail>>()
    private val characterDetailsSubject = BehaviorSubject.create<Model.CharacterDetail>()

    init {
        LOTRApiService.apiService.fetchCharacters()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { it.characterDetails }
            .subscribeBy(
                onNext = charactersSubject::onNext,
                onError = RxJavaPlugins::onError
            ).addTo(disposable)

        charactersSubject
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMapIterable { it }
            .subscribeBy(
                onNext = characterDetailsSubject::onNext,
                onError = RxJavaPlugins::onError
            ).addTo(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }

    /**
     * Input
     */

    /**
     * Output
     */

    fun characters(): BehaviorSubject<List<Model.CharacterDetail>> = charactersSubject

    fun characterDetails(): BehaviorSubject<Model.CharacterDetail> = characterDetailsSubject

}
