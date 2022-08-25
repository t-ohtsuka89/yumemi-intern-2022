package com.example.demo.domain.repository

import com.example.demo.domain.entity.User
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Int?> {

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    fun findByEmail(email: String): User?
}