package com.example.demo.domain.repository

import com.example.demo.domain.entity.Post
import org.springframework.data.repository.CrudRepository

interface PostRepository : CrudRepository<Post, Int?>