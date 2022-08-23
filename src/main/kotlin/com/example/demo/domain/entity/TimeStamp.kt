package com.example.demo.domain.entity

import java.util.*
import javax.persistence.Column
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class TimeStamp {
    @Column(
        name = "created_at",
        columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP",
        nullable = false,
        insertable = false,
        updatable = false
    )
    var createdAt: Date? = null

    @Column(
        name = "updated_at",
        columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP",
        nullable = false,
        insertable = false,
        updatable = false
    )
    var updatedAt: Date? = null

    @Column(name = "deleted_at", columnDefinition = "DATETIME DEFAULT NULL")
    var deletedAt: Date? = null
}