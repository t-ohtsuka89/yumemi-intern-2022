package com.example.demo.domain.entity

import javax.persistence.*

@Entity
@Table(name = "posts")
class Post(
    @Column(nullable = false)
    var userId: Int,

    @Column(nullable = false)
    var text: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
) : TimeStamp()