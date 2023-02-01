package com.example.musicwiki.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.setupWithNavController
import com.example.musicwiki.R
import kotlinx.android.synthetic.main.fragment_genre_details.view.*

class GenreDetailsFragment : Fragment() {

    val args: GenreDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_genre_details, container, false)

        val nestedNavHostFragment =
            childFragmentManager.findFragmentById(R.id.genreFragmentContainer) as? NavHostFragment
        val navController = nestedNavHostFragment?.navController!!
        view.bottomNavigationView.setupWithNavController(navController)
        return view
    }

}