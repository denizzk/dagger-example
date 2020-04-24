package com.dkarakaya.daggerexample.book

import androidx.lifecycle.ViewModel
import com.dkarakaya.daggerexample.repository.LOTRApiService.Companion.apiService
import com.dkarakaya.daggerexample.repository.Model
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.plugins.RxJavaPlugins.onError
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject

class BookViewModel : ViewModel() {

    private val disposable = CompositeDisposable()

    private val booksSubject = BehaviorSubject.create<List<Model.BookDetail>>()
    private val bookDetailsSubject = BehaviorSubject.create<Model.BookDetail>()

    init {
        apiService.fetchBooks()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { it.bookDetails }
            .subscribeBy(
                onNext = booksSubject::onNext,
                onError = ::onError
            ).addTo(disposable)

        booksSubject
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMapIterable { it }
            .subscribeBy(
                onNext = bookDetailsSubject::onNext,
                onError = ::onError
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

    fun books(): BehaviorSubject<List<Model.BookDetail>> = booksSubject

    fun bookDetails(): BehaviorSubject<Model.BookDetail> = bookDetailsSubject
}
