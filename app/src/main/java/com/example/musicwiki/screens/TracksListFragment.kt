package com.example.musicwiki.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.musicwiki.R
import com.example.musicwiki.data.remote.model.TempObject
import com.example.musicwiki.utils.MainAdapter
import com.example.musicwiki.utils.Status
import com.example.musicwiki.viewmodel.MainViewModel

import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_tracks_list.view.*

@AndroidEntryPoint
class TracksListFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()

    // TODO use hilt
    private lateinit var myAdapter: MainAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tracks_list, container, false)
        subscribeToObservers()

        myAdapter = MainAdapter{
//            findNavController().navigate(AlbumsListFragmentDirections.toAlbumDetailsFragment(it.name))
        }
        view.tracksRecyclerView.apply {
            adapter = myAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)
        }
        return view
    }

    private fun subscribeToObservers() {
        viewModel.tracksList.observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    val newList = it.data!!.map { tracks ->
                        TempObject(name= tracks.name?:"Album", image=(tracks.image[0].text)?:"")
                    }
                    myAdapter.changeList(newList)
                    Toast.makeText(requireContext(), "Retrieve successful", Toast.LENGTH_LONG).show()
                }
                Status.LOADING -> {
                    Toast.makeText(requireContext(), "Loading Tracks...", Toast.LENGTH_LONG).show()
                }
                Status.ERROR -> {
                    Toast.makeText(requireContext(), it.message!!, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}