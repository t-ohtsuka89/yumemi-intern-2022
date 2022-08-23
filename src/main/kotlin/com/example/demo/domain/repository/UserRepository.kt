package com.example.demo.domain.repository

import com.example.demo.domain.entity.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Int?>