package com.skillblog.api.controller

import com.skillblog.api.domain.post.PostRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/post")
class PostController {
    @Autowired
    lateinit var postRepo: PostRepo

    @GetMapping("/{codes}")
    fun findPosts(@PathVariable codes:Array<Int>){
        for (code in codes) {
            println("code : $code")
            val postEntity = postRepo.findByCode(code)

            for (postEntity in postEntity) {
                println(postEntity.title)
            }
        }

    }
    @GetMapping("/test")
    fun findPosts1(){
        val postEntity = postRepo.findByCode(1001)
        for (postEntity in postEntity) {
            println(postEntity.title)
        }


    }
}