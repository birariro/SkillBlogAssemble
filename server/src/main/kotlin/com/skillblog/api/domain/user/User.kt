package com.skillblog.api.domain.user

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class User (
        @Id
        val id:String,

        val pwd:String,
        val email:String
        )