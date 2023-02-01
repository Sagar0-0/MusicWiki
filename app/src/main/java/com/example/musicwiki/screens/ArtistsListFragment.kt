package com.example.musicwiki.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.musicwiki.R
import com.example.musicwiki.viewmodel.MainViewModel


import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_artists_list.view.*

@AndroidEntryPoint
class ArtistsListFragment : Fragment() {

    private val viewModel : MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_artists_list, container, false)
        return  view
    }
}