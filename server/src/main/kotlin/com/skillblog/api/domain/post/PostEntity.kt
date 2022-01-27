package com.skillblog.api.domain.post

import com.skillblog.api.domain.site.SiteEntity
import javax.persistence.*

@Entity
@Table(name = "post")
class PostEntity(
        @Column(nullable = false)
        val company: String,
        @Column(nullable = false)
        val code : Int,
        @Column(nullable = false)
        val title: String,
        @Column(nullable = false)
        val postLink: String
)
{
        @Id @Column(name = "post_id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "site_id")
        lateinit var site : SiteEntity
}