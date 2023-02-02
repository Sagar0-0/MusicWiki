package com.example.musicwiki.repositories

import com.example.musicwiki.data.remote.model.Album
import com.example.musicwiki.data.remote.model.ArtistXX
import com.example.musicwiki.data.remote.model.Tag
import com.example.musicwiki.data.remote.model.Track
import com.example.musicwiki.utils.Resource

interface MainRepository {

    suspend fun getTopTags(): Resource<List<Tag>>

    suspend fun getTagInfo(tag: String): Resource<String>

    suspend fun getAlbums(tag: String): Resource<List<Album>>

    suspend fun getTracks(tag: String): Resource<List<Track>>

    suspend fun getArtists(tag: String): Resource<List<ArtistXX>>

}