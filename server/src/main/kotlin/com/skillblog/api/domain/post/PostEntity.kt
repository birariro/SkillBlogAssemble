package com.skillblog.api.domain.post

import javax.persistence.*

@Entity
class PostEntity(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,
        @Column(nullable = false)
        val targetName: String,
        @Column(nullable = false)
        val title: String,

)