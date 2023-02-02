package com.example.musicwiki.repositories

import com.example.musicwiki.data.remote.NetworkApi
import com.example.musicwiki.data.remote.model.Album
import com.example.musicwiki.data.remote.model.ArtistXX
import com.example.musicwiki.data.remote.model.Tag
import com.example.musicwiki.data.remote.model.Track
import com.example.musicwiki.utils.Resource
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val networkApi: NetworkApi
) : MainRepository {

    override suspend fun getTopTags(): Resource<List<Tag>> {
        return try {
            val response = networkApi.getTopTags()
            if(response.isSuccessful){
                response.body()?.let {
                    return@let Resource.success(it.toptags.tag)
                } ?: Resource.error("Unknown Error occurred")
            }else{
                Resource.error("Unknown Error occurred")
            }
        } catch (e: Exception) {
            Resource.error("Couldn't reach the server. Check Internet connection")
        }
    }

    override suspend fun getTagInfo(tag: String): Resource<String> {
        return try {
            val response = networkApi.getTagInfo(tagName = tag)
            if(response.isSuccessful){
                response.body()?.let {
                    return@let Resource.success(it.tag.wiki.content)
                } ?: Resource.error("Unknown Error occurred")
            }else{
                Resource.error("Unknown Error occurred")
            }
        } catch (e: Exception) {
            Resource.error("Couldn't reach the server. Check Internet connection")
        }
    }

    override suspend fun getAlbums(tag: String): Resource<List<Album>> {
        return try {
            val response = networkApi.getAlbums(tagName = tag)
            if(response.isSuccessful){
                response.body()?.let {
                    return@let Resource.success(it.albums.album)
                } ?: Resource.error("Unknown Error occurred")
            }else{
                Resource.error("Unknown Error occurred")
            }
        } catch (e: Exception) {
            Resource.error("Couldn't reach the server. Check Internet connection")
        }
    }

    override suspend fun getTracks(tag: String): Resource<List<Track>> {
        return try {
            val response = networkApi.getTracks(tag)
            if(response.isSuccessful){
                response.body()?.let {
                    return@let Resource.success(it.tracks.track)
                } ?: Resource.error("Unknown Error occurred")
            }else{
                Resource.error("Unknown Error occurred")
            }
        } catch (e: Exception) {
            Resource.error("Couldn't reach the server. Check Internet connection")
        }
    }

    override suspend fun getArtists(tag: String): Resource<List<ArtistXX>> {
        return try {
            val response = networkApi.getArtists(tag)
            if(response.isSuccessful){
                response.body()?.let {
                    return@let Resource.success(it.topartists.artist)
                } ?: Resource.error("Unknown Error occurred")
            }else{
                Resource.error("Unknown Error occurred")
            }
        } catch (e: Exception) {
            Resource.error("Couldn't reach the server. Check Internet connection")
        }
    }


}
