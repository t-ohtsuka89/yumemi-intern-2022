package com.example.demo.domain.repository

import com.example.demo.domain.entity.Post
import org.springframework.data.repository.CrudRepository


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
interface PostRepository : CrudRepository<Post, Int?>