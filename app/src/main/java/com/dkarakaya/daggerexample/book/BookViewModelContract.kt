package com.dkarakaya.daggerexample.book

import com.dkarakaya.daggerexample.repository.Model
import io.reactivex.subjects.BehaviorSubject

interface BookViewModelContract {

    interface Input

    interface Output {

        fun books(): BehaviorSubject<Model.Book>

    }
}
