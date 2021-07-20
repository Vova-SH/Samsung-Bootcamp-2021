package com.clean.arch.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.clean.arch.mvvm.ui.popular.MoviePopularFragment

class RootActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.root_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MoviePopularFragment.newInstance())
                    .commitNow()
        }
    }
}