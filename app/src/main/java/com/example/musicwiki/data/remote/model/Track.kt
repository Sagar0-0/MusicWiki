package com.example.musicwiki.data.remote.model

data class Track(
    val attr: AttrXXXX,
    val artist: ArtistX,
    val duration: String,
    val image: List<ImageX>,
    val mbid: String,
    val name: String,
    val streamable: Streamable,
    val url: String
)