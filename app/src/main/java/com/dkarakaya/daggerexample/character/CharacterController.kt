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
                hair(if (!details.hair.isNullOrEmpty()) details.hair else "-")
                death(if (!details.death.isNullOrEmpty()) details.death else "-")
                realm(if (!details.realm.isNullOrEmpty()) details.realm else "-")
                spouse(if (!details.spouse.isNullOrEmpty()) details.spouse else "-")
                wikiUrl(details.wikiUrl)
                birth(if (!details.birth.isNullOrEmpty()) details.birth else "-")
                race(details.race)
                gender(if (!details.gender.isNullOrEmpty()) details.gender else "-")
                height(if (!details.height.isNullOrEmpty()) details.height else "-")
//                onClickListener(View.OnClickListener {
//                    deepLinkClickListener(deepLink.deepLink)
//                })
            }
        }
    }

}
