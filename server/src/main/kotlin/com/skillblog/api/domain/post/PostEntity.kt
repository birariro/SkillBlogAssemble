package com.skillblog.api.domain.post

import javax.persistence.*

@Entity
class PostEntity(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,
        @Column(nullable = false)
        val company: String,
        @Column(nullable = false)
        val code : Int,
        @Column(nullable = false)
        val title: String,
        @Column(nullable = false)
        val link: String,

)