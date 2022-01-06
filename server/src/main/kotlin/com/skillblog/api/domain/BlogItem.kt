package com.skillblog.api.domain

import java.util.*
import javax.persistence.*

@Entity
class BlogItem(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @Column(nullable = false)
        val title: String,

        @Column(columnDefinition = "TEXT", nullable = false)
        val description: String,
        val author: String,
        @Column(columnDefinition = "TEXT", nullable = false)
        val imageLink: String,
        val link: String,
        val date: Date
)