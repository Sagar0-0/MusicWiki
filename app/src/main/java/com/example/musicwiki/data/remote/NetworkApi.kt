package com.example.musicwiki.data.remote

import com.example.musicwiki.data.remote.model.*
import com.example.musicwiki.utils.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkApi {
    @GET("2.0")
    suspend fun getTopTags(
        @Query("method")
        method: String = query_top_tags,
        @Query("api_key")
        key: String = API_KEY,
        @Query("format")
        format: String = response_format
    ) : Response<TopTagsResponse>

    @GET("2.0")
    suspend fun getTagInfo(
        @Query("method")
        method: String = query_tag_info,
        @Query("tag")
        tagName: String = "disco",
        @Query("api_key")
        key: String = API_KEY,
        @Query("format")
        format: String = response_format
    ) : Response<TagInfoResponse>

    @GET("2.0")
    suspend fun getAlbums(
        @Query("method")
        method: String = query_albums,
        @Query("tag")
        tagName: String = "disco",
        @Query("api_key")
        key: String = API_KEY,
        @Query("format")
        format: String = response_format
    ) : Response<AlbumsResponse>


    @GET("2.0")
    suspend fun getTracks(
        @Query("method")
        method: String = query_tracks,
        @Query("tag")
        tagName: String = "disco",
        @Query("api_key")
        key: String = API_KEY,
        @Query("format")
        format: String = response_format
    ) : Response<TracksResponse>

    @GET("2.0")
    suspend fun getArtists(
        @Query("method")
        method: String = query_artists,
        @Query("tag")
        tagName: String = "disco",
        @Query("api_key")
        key: String = API_KEY,
        @Query("format")
        format: String = response_format
    ) : Response<ArtistsResponse>

}