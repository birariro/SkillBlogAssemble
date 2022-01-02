package com.skillblog.api.controller.dto

import java.util.*

data class BlogItemResponse (
    val company:String,
    val title:String ,
    val description : String,
    val author:String,
    val link : String,
    val data : Date
)