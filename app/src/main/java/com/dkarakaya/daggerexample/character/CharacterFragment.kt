package com.dkarakaya.daggerexample.character

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager

import com.dkarakaya.daggerexample.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_generic.*

class CharacterFragment : Fragment(R.layout.fragment_generic) {

    private val viewModel by lazy {
        CharacterViewModel()
    }

    private val disposable = CompositeDisposable()

    override fun onStart() {
        super.onStart()

        initRecyclerView()
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }

    private fun initRecyclerView() {
        val recyclerView = recycler_view
        val controller = CharacterController()

        recyclerView.apply {
            setHasFixedSize(true)
            adapter = controller.adapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        showCharacters(controller)
//        controller.deepLinkClickListener = { deepLink ->
//            openDeepLink(deepLink = deepLink)
//        }
    }

    private fun showCharacters(controller: CharacterController) {
        viewModel.characters()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = { controller.characterDetails = it },
                onError = RxJavaPlugins::onError
            ).addTo(disposable)
    }

    companion object {
        private const val TAG = "CharacterFragment"
    }

}
