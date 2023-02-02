package com.example.musicwiki.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicwiki.data.remote.model.Tag
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

    private val _tagInfo = MutableLiveData<Resource<String>>()
    val tagInfo : LiveData<Resource<String>> = _tagInfo

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
        _tagInfo.value = Resource.loading()
        viewModelScope.launch {
            _tagInfo.value = repository.getTagInfo(tag)
        }
    }


}