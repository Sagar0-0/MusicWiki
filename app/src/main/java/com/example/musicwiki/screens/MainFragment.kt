package com.example.musicwiki.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.musicwiki.R
import kotlinx.android.synthetic.main.fragment_main.view.*

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        view.myTextView.setOnClickListener {
            val action = MainFragmentDirections.toGenreDetails(genreName = "rock")
            Navigation.findNavController(view).navigate(action)
        }
        return view
    }
}