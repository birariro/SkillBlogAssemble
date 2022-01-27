package com.skillblog.api.domain.site

import com.skillblog.api.domain.post.PostEntity
import javax.persistence.*

@Entity
@Table(name = "site")
class SiteEntity (
       val code : Int,
       val company:String,
       val link:String,
){

       @Id @GeneratedValue @Column(name = "site_id")
       val id:Long = 0

       @OneToMany(mappedBy = "site")
       val posts:MutableList<PostEntity> = mutableListOf()

       fun addPost(postEntity: PostEntity){
              posts.add(postEntity)
              postEntity.site = this
       }
}