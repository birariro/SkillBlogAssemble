package com.skillblog.api.service

import com.skillblog.api.domain.user.User
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import javax.persistence.Transient

@SpringBootTest
internal class UserServiceTest {

    @Autowired
    lateinit var userService: UserService

    @Test
    @Transient
    fun login() {
        val user = User(id = "k4keye",pwd = "pwd1234",email = "k4keye@naver.com")
        if(userService.createUser(user)){
            var result = userService.login(user.id,user.pwd)
            assertEquals(true,result)

            result = userService.login("example",user.pwd)
            assertEquals(false,result)

            result = userService.login(user.id,"example")
            assertEquals(false,result)
        }

    }

    @Test
    fun createUser() {
        val user = User(id = "k4keye",pwd = "pwd1234",email = "k4keye@naver.com")
        var result = userService.createUser(user)
        assertEquals(true,result)

        result = userService.createUser(user)
        assertEquals(false,result)
    }
}