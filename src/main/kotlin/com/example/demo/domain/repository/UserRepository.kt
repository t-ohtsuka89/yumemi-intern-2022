package com.example.demo.domain.repository

import com.example.demo.domain.entity.User
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Int?> {

    @Query(
        "SELECT * FROM users WHERE email = ?1 AND deleted_at IS NULL ORDER BY created_at DESC LIMIT 1",
        nativeQuery = true
    )
    fun findByEmail(email: String): User?
}