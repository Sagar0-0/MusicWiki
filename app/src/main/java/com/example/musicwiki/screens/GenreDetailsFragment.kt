package com.example.musicwiki.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.setupWithNavController
import com.example.musicwiki.R
import com.example.musicwiki.utils.Status
import com.example.musicwiki.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_genre_details.view.*

@AndroidEntryPoint
class GenreDetailsFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()
    private val args: GenreDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_genre_details, container, false)

        val tag = args.genreName
        view.genre_title_text.text = tag
        viewModel.getTagInfo(tag)
        viewModel.getAlbums()
        viewModel.getArtists()
        viewModel.getTracks()
        subscribeToObservers(view.genre_description_text)

        val nestedNavHostFragment =
            childFragmentManager.findFragmentById(R.id.genreFragmentContainer) as? NavHostFragment
        val navController = nestedNavHostFragment?.navController!!
        view.bottomNavigationView.setupWithNavController(navController)
        return view
    }

    private fun subscribeToObservers(view: TextView) {
        viewModel.tagInfo.observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    view.text = it.data
                }
                Status.LOADING -> {
                    view.text = "Loading..."
                }
                Status.ERROR -> {
                    view.text = "Can not retrieve content at this moment"
                }
            }
        }
    }
}