package com.dkarakaya.daggerexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.bottom_navigation_view.*


class MainActivity : DaggerAppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            showFragment(com.dkarakaya.book.BookFragment())
        }
        navigate()
    }

    private fun navigate() {
        navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_books -> showFragment(com.dkarakaya.book.BookFragment())
                R.id.action_movies -> showFragment(com.dkarakaya.movie.MovieFragment())
                R.id.action_characters -> showFragment(com.dkarakaya.character.CharacterFragment())
            }
            true
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (navigation.selectedItemId != R.id.action_books) {
            navigation.selectedItemId = R.id.action_books
        } else {
            finish()
        }
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.container, fragment, null)
            .commit()
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}
