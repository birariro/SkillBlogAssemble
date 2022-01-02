package com.skillblog.api.controller

import com.skillblog.api.controller.dto.BlogItemResponse
import com.skillblog.api.service.BlogService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BlogController {

    @Autowired
    lateinit var blogService : BlogService

    @GetMapping("blog-item")
    fun getBlogItemList() : List<BlogItemResponse> {
//        var dataList = mutableListOf<BlogItemResponse>().apply {
//            add( BlogItemResponse("k4keye","k4keye hello","world"))
//            add( BlogItemResponse("k4keye","k4keye hello","world"))
//            add( BlogItemResponse("k4keye","k4keye hello","world"))
//        }
        blogService.test()
        return mutableListOf<BlogItemResponse>()
    }
}