package com.dkarakaya.book

import com.airbnb.epoxy.EpoxyController
import com.dkarakaya.core.repository.Model

class BookController : EpoxyController() {

    var bookDetails: List<Model.BookDetail> = listOf()
        set(value) {
            field = value
            requestModelBuild()
        }

//    var deepLinkClickListener: (deepLink: String) -> Unit = { }

    override fun buildModels() {
        bookDetails.forEachIndexed { index, details ->
            book {
                id(index)
                value(details.name)
//                onClickListener(View.OnClickListener {
//                    deepLinkClickListener(deepLink.deepLink)
//                })
            }
        }
    }

}
