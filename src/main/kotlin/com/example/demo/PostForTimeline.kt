package com.example.demo

import com.example.demo.domain.entity.TimeStamp
import java.util.Date

class PostForTimeline(
    val id: Int,
    val username: String,
    val userId: Int,
    val text: String,
) : TimeStamp() {
    constructor(
        id: Int,
        username: String,
        userId: Int,
        text: String,
        createdAt: Date,
        updatedAt: Date,
    ) : this(
        id,
        username,
        userId,
        text
    ) {
        this.createdAt = createdAt
        this.updatedAt = updatedAt
    }
}