package com.example.musicwiki.data.remote.model

data class Album(
    val attr: AttrXX,
    val artist: Artist,
    val image: List<Image>,
    val mbid: String,
    val name: String,
    val url: String
)