package com.dkarakaya.daggerexample.movie

import androidx.lifecycle.ViewModel
import com.dkarakaya.daggerexample.repository.LOTRApiService
import com.dkarakaya.daggerexample.repository.Model
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject

class MovieViewModel : ViewModel() {

    private val disposable = CompositeDisposable()

    private val moviesSubject = BehaviorSubject.create<List<Model.MovieDetail>>()
    private val movieDetailsSubject = BehaviorSubject.create<Model.MovieDetail>()

    init {
        LOTRApiService.apiService.fetchMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { it.movieDetails }
            .subscribeBy(
                onNext = moviesSubject::onNext,
                onError = RxJavaPlugins::onError
            ).addTo(disposable)

        moviesSubject
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMapIterable { it }
            .subscribeBy(
                onNext = movieDetailsSubject::onNext,
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

    fun movies(): BehaviorSubject<List<Model.MovieDetail>> = moviesSubject

    fun movieDetails(): BehaviorSubject<Model.MovieDetail> = movieDetailsSubject


}
