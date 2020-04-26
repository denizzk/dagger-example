package com.dkarakaya.daggerexample.character

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.dkarakaya.daggerexample.R

@EpoxyModelClass(layout = R.layout.item_character)
abstract class CharacterModel : EpoxyModelWithHolder<CharacterModel.CharacterHolder>() {

    @EpoxyAttribute
    lateinit var height: String

    @EpoxyAttribute
    lateinit var race: String

    @EpoxyAttribute
    lateinit var gender: String

    @EpoxyAttribute
    lateinit var birth: String

    @EpoxyAttribute
    lateinit var spouse: String

    @EpoxyAttribute
    lateinit var death: String

    @EpoxyAttribute
    lateinit var realm: String

    @EpoxyAttribute
    lateinit var hair: String

    @EpoxyAttribute
    lateinit var name: String

    @EpoxyAttribute
    lateinit var wikiUrl: String

    override fun bind(holder: CharacterHolder) {
        holder.height.text = height
        holder.race.text = race
        holder.gender.text = gender
        holder.birth.text = birth
        holder.spouse.text = spouse
        holder.death.text = death
        holder.realm.text = realm
        holder.hair.text = hair
        holder.name.text = name
        holder.height.text = height
        holder.wikiUrl.text = wikiUrl
    }

    inner class CharacterHolder : EpoxyHolder() {

        lateinit var height: TextView
        lateinit var race: TextView
        lateinit var gender: TextView
        lateinit var birth: TextView
        lateinit var spouse: TextView
        lateinit var death: TextView
        lateinit var realm: TextView
        lateinit var hair: TextView
        lateinit var name: TextView
        lateinit var wikiUrl: TextView

        override fun bindView(itemView: View) {
            height = itemView.findViewById(R.id.height_value)
            race = itemView.findViewById(R.id.race_value)
            gender = itemView.findViewById(R.id.gender_value)
            birth = itemView.findViewById(R.id.birth_value)
            spouse = itemView.findViewById(R.id.spouse_value)
            death = itemView.findViewById(R.id.death_value)
            realm = itemView.findViewById(R.id.realm_value)
            hair = itemView.findViewById(R.id.hair_value)
            name = itemView.findViewById(R.id.name_value)
            wikiUrl = itemView.findViewById(R.id.wiki_value)
        }

    }
}
