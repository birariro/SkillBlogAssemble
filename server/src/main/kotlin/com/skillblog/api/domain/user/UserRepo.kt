package com.skillblog.api.domain.user

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepo : JpaRepository<User,String>{
}