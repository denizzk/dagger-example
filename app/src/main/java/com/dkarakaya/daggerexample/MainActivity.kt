package com.dkarakaya.daggerexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.dkarakaya.daggerexample.book.BookFragment
import com.dkarakaya.daggerexample.character.CharacterFragment
import kotlinx.android.synthetic.main.bottom_navigation_view.*


class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navigate()
    }

    private fun navigate() {
        navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_books -> showFragment(BookFragment())
                R.id.action_movies -> showFragment(CharacterFragment())
                R.id.action_characters -> showFragment(CharacterFragment())
            }
            true
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
