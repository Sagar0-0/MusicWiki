package com.example.musicwiki.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.musicwiki.R

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlbumsListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_album_list, container, false)

        return view
    }

}