package com.dkarakaya.daggerexample.character

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dkarakaya.daggerexample.R
import com.dkarakaya.daggerexample.viewmodel.ViewModelFactory
import dagger.android.support.DaggerFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_generic.*
import javax.inject.Inject

class CharacterFragment : DaggerFragment(R.layout.fragment_generic) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var viewModel: CharacterViewModel

    private val disposable = CompositeDisposable()

    override fun onStart() {
        super.onStart()

        viewModel = ViewModelProvider(this, viewModelFactory).get(CharacterViewModel::class.java)
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
