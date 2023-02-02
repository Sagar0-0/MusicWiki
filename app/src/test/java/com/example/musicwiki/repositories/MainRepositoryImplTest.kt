package com.example.musicwiki.repositories

import com.example.musicwiki.data.remote.model.Album
import com.example.musicwiki.data.remote.model.ArtistXX
import com.example.musicwiki.data.remote.model.Tag
import com.example.musicwiki.data.remote.model.Track
import com.example.musicwiki.utils.Resource


class MainRepositoryImplTest : MainRepository {

    private val tags = mutableListOf<Tag>()
    private val albums = mutableListOf<Album>()
    private val tracks = mutableListOf<Track>()
    private val artists = mutableListOf<ArtistXX>()
    private val tagInfo = "Some info"
    private var shouldReturnNetworkError = false



    fun returnNetworkError(value: Boolean){
        shouldReturnNetworkError= value
    }

    override suspend fun getTopTags(): Resource<List<Tag>> {
        return if(shouldReturnNetworkError){
            Resource.error("Error")
        }else{
            Resource.success(tags)
        }
    }

    override suspend fun getTagInfo(tag: String): Resource<String> {
        return if(shouldReturnNetworkError){
            Resource.error("Error")
        }else{
            Resource.success(tagInfo)
        }
    }

    override suspend fun getAlbums(tag: String): Resource<List<Album>> {
        return if(shouldReturnNetworkError){
            Resource.error("Error")
        }else{
            Resource.success(albums)
        }
    }

    override suspend fun getTracks(tag: String): Resource<List<Track>> {
        return if(shouldReturnNetworkError){
            Resource.error("Error")
        }else{
            Resource.success(tracks)
        }
    }

    override suspend fun getArtists(tag: String): Resource<List<ArtistXX>> {
        return if(shouldReturnNetworkError){
            Resource.error("Error")
        }else{
            Resource.success(artists)
        }
    }
}