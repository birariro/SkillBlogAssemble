package com.skillblog.api.domain.post

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepo :  JpaRepository<PostEntity,Long>{
}