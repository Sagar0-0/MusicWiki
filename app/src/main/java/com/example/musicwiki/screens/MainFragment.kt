package com.example.musicwiki.screens

import android.os.Bundle
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
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()
    @Inject
    lateinit var myAdapter: MainAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        subscribeToObservers()
        myAdapter.clickListener = {
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
                    Toast.makeText(requireContext(), "Got Result", Toast.LENGTH_LONG).show()
                    it.data?.let { list ->
                        myAdapter.changeList(list.map { tag ->
                            TestObject(tag.name, "")
                        })
                    }
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