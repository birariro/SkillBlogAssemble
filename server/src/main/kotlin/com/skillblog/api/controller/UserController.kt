package com.skillblog.api.controller

import com.skillblog.api.controller.dto.LoginDto
import com.skillblog.api.domain.user.User
import com.skillblog.api.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController {
    @Autowired
    lateinit var loginService: UserService
    @PostMapping("/login")
    fun login(@RequestBody loginDto: LoginDto){
        loginService.login(loginDto.id,loginDto.pwd)
    }

    @PostMapping
    fun createUser(@RequestBody user:User){
        loginService.createUser(user)
    }
}