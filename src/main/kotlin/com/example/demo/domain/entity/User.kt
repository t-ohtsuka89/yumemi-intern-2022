package com.example.demo.domain.entity

import javax.persistence.*

@Entity
@Table(name = "users")
class User(
    @Column(nullable = false)
    var username: String,

    @Column(nullable = false)
    var email: String,

    @Column(nullable = false)
    var password: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
) : TimeStamp()