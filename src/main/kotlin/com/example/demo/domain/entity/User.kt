package com.example.demo.domain.entity

import javax.persistence.*

@Entity
@Table(name = "users")
class User : TimeStamp() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null

    @Column(nullable = false)
    var username: String? = null

    @Column(nullable = false)
    var email: String? = null

    @Column(nullable = false)
    var password: String? = null
}