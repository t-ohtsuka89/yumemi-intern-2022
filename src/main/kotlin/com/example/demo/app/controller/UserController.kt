package com.example.demo.app.controller


import com.example.demo.domain.entity.User
import com.example.demo.domain.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping(path = ["/user"])
class UserController {
    @Autowired
    lateinit var userRepository: UserRepository

    @PostMapping
    @ResponseBody
    fun addUser(
        @RequestParam(required = true) username: String,
        @RequestParam(required = true) email: String,
        @RequestParam(required = true) password: String
    ) {
        val passwordEncoder = BCryptPasswordEncoder()
        val digest = passwordEncoder.encode(password)
        val n = User()
        n.username = username
        n.email = email
        n.password = digest
        userRepository.save(n)
    }
}