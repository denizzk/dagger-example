package com.dkarakaya.daggerexample.character

import com.airbnb.epoxy.EpoxyController
import com.dkarakaya.daggerexample.repository.Model

class CharacterController : EpoxyController() {

    var characterDetails: List<Model.CharacterDetail> = listOf()
        set(value) {
            field = value
            requestModelBuild()
        }

//    var deepLinkClickListener: (deepLink: String) -> Unit = { }

    override fun buildModels() {
        characterDetails.forEachIndexed { index, details ->
            character {
                id(index)
                name(details.name)
                hair(details.hair)
                death(details.death)
                realm(details.realm)
                spouse(details.spouse)
                wikiUrl(details.wikiUrl)
                birth(details.birth)
                race(details.race)
                gender(details.gender)
                height(details.height)
//                onClickListener(View.OnClickListener {
//                    deepLinkClickListener(deepLink.deepLink)
//                })
            }
        }
    }

}
