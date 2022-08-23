package com.example.demo.domain.repository

import com.example.demo.domain.entity.User
import org.springframework.data.repository.CrudRepository


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
interface UserRepository : CrudRepository<User, Int?>