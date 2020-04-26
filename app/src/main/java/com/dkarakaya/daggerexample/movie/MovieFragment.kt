package com.dkarakaya.daggerexample.movie

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dkarakaya.daggerexample.R
import dagger.android.support.DaggerFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_generic.*
import javax.inject.Inject

class MovieFragment : DaggerFragment(R.layout.fragment_generic) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: MovieViewModel

    private val disposable = CompositeDisposable()

    override fun onStart() {
        super.onStart()

        viewModel = ViewModelProvider(this, viewModelFactory).get(MovieViewModel::class.java)
        initRecyclerView()
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }

    private fun initRecyclerView() {
        val recyclerView = recycler_view
        val controller = MovieController()

        recyclerView.apply {
            setHasFixedSize(true)
            adapter = controller.adapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        showMovies(controller)
//        controller.deepLinkClickListener = { deepLink ->
//            openDeepLink(deepLink = deepLink)
//        }
    }

    private fun showMovies(controller: MovieController) {
        viewModel.movies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = { controller.movieDetails = it },
                onError = RxJavaPlugins::onError
            ).addTo(disposable)
    }

    companion object {
        private const val TAG = "BookFragment"
    }


}
