package com.example.musicwiki.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicwiki.data.remote.model.Album
import com.example.musicwiki.data.remote.model.ArtistXX
import com.example.musicwiki.data.remote.model.Tag
import com.example.musicwiki.data.remote.model.Track
import com.example.musicwiki.repositories.MainRepository
import com.example.musicwiki.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    private val _tagsList = MutableLiveData<Resource<List<Tag>>>()
    val tagsList : LiveData<Resource<List<Tag>>> = _tagsList

    private val _albumsList = MutableLiveData<Resource<List<Album>>>()
    val albumsList : LiveData<Resource<List<Album>>> = _albumsList

    private val _artistsList = MutableLiveData<Resource<List<ArtistXX>>>()
    val artistsList : LiveData<Resource<List<ArtistXX>>> = _artistsList

    private val _tracksList = MutableLiveData<Resource<List<Track>>>()
    val tracksList : LiveData<Resource<List<Track>>> = _tracksList

    private val _tagInfo = MutableLiveData<Resource<String>>()
    val tagInfo : LiveData<Resource<String>> = _tagInfo

    private val _tagName = MutableLiveData<String>()
    val tagName : LiveData<String> = _tagName


    init{
        getTags()
    }

    private fun getTags() {
        _tagsList.value = Resource.loading()
        viewModelScope.launch {
            _tagsList.value = repository.getTopTags()
        }
    }
    fun getTagInfo(tag: String) {
        _tagName.value = tag
        _tagInfo.value = Resource.loading()
        viewModelScope.launch {
            _tagInfo.value = repository.getTagInfo(tag)
        }
    }

    fun getAlbums() {
        _albumsList.value = Resource.loading()
        viewModelScope.launch {
            _albumsList.value = repository.getAlbums(tagName.value!!)
        }
    }

    fun getArtists() {
        _artistsList.value = Resource.loading()
        viewModelScope.launch {
            _artistsList.value = repository.getArtists(tagName.value!!)
        }
    }

    fun getTracks() {
        _tracksList.value = Resource.loading()
        viewModelScope.launch {
            _tracksList.value = repository.getTracks(tagName.value!!)
        }
    }
}