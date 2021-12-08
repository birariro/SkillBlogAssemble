package com.example.skillblogassemble.domain.model

data class BlogItem(
    val company:String,
    val title : String,
    val content : String,
    val color : Int,
    val iconId : Int,
    val link : String
)
