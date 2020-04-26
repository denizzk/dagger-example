package com.dkarakaya.daggerexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.dkarakaya.daggerexample.book.BookFragment
import com.dkarakaya.daggerexample.character.CharacterFragment
import com.dkarakaya.daggerexample.movie.MovieFragment
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.bottom_navigation_view.*


class MainActivity : DaggerAppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            showFragment(BookFragment())
        }
        navigate()
    }

    private fun navigate() {
        navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_books -> showFragment(BookFragment())
                R.id.action_movies -> showFragment(MovieFragment())
                R.id.action_characters -> showFragment(CharacterFragment())
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
