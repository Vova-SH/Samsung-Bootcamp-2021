package com.clean.arch.mvvm.ui.popular

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.SharedElementCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.AutoTransition
import androidx.transition.TransitionInflater
import com.clean.arch.mvvm.R
import com.clean.arch.mvvm.data.entities.Movie
import com.clean.arch.mvvm.ui.adapter.MovieAdapter
import com.clean.arch.mvvm.ui.movie.MovieFragment
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class MoviePopularFragment : Fragment(R.layout.recycler_fragment) {

    private val viewModel: MoviePopularViewModel by viewModel()

    private val adapter = MovieAdapter(::onItemClick)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler)
        recyclerView.adapter = adapter
        /*
        //For Kotlin Flow
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.moviePage.distinctUntilChanged().collectLatest(adapter::submitData)
        }
        */

        //LiveData
        viewModel.moviePage.observe(viewLifecycleOwner) {
            adapter.submitData(viewLifecycleOwner.lifecycle, it)
        }
    }

    private fun onItemClick(movie : Movie) {
        parentFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .replace(R.id.container, MovieFragment.newInstance(movie))
            .addToBackStack(null)
            .commit()

    }

    companion object {
        fun newInstance() = MoviePopularFragment()
    }

}