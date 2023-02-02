package com.example.musicwiki.screens

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.musicwiki.R
import com.example.musicwiki.data.remote.model.TestObject
import com.example.musicwiki.utils.MainAdapter
import com.example.musicwiki.utils.Status
import com.example.musicwiki.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_main.view.*
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()

    // TODO use hilt
    lateinit var myAdapter: MainAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        subscribeToObservers()
        myAdapter = MainAdapter{
            findNavController().navigate(MainFragmentDirections.toGenreDetails(it.name))
        }
        view.genreRecyclerView.apply {
            adapter = myAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)
        }
        return view
    }

    private fun subscribeToObservers() {
        viewModel.tagsList.observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    val newList = it.data!!.map { tag ->
                        TestObject(tag.name, "https://img.freepik.com/free-vector/music-vinyl-record-label-with-sound-notes_1017-33905.jpg?w=2000")
                    }
                    myAdapter.changeList(newList)
                }
                Status.LOADING -> {
                    Toast.makeText(requireContext(), "Loading...", Toast.LENGTH_LONG).show()
                }
                Status.ERROR -> {
                    Toast.makeText(requireContext(), it.message!!, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

}