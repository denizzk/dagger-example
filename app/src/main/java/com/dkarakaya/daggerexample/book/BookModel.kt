package com.dkarakaya.daggerexample.book

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.dkarakaya.daggerexample.R

@EpoxyModelClass(layout = R.layout.item_book)
abstract class BookModel : EpoxyModelWithHolder<BookModel.BookHolder>() {

    @EpoxyAttribute
    lateinit var value: String

    override fun bind(holder: BookHolder) {
        holder.valueText.text = value
    }

    inner class BookHolder : EpoxyHolder() {

        lateinit var valueText: TextView

        override fun bindView(itemView: View) {
            valueText = itemView.findViewById(R.id.value_text)
        }

    }
}
