package com.example.demo.app.controller

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping(path = ["/private"])
class PrivateTestController {
    @GetMapping
    @ResponseBody
    fun private(): String {
        val authentication = SecurityContextHolder.getContext().authentication
        val username = authentication.name
        return "private $username"
    }
}