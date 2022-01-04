package com.skillblog.api.domain

import java.util.*
import javax.persistence.*

@Entity
data class BlogItem(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long?,

        @Column(nullable = false)
        val title: String,

        @Column(columnDefinition = "TEXT", nullable = false)
        val description: String,
        val author: String,
        val link: String,
        val date: Date
)