package com.example.demo.domain.entity

import javax.persistence.*

@Entity
@Table(name = "posts")
class Post : TimeStamp() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null

    @Column(nullable = false)
    var userId: Int? = null

    @Column(nullable = false)
    var text: String? = null
}