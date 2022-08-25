package com.example.demo.web

import com.example.demo.domain.entity.Post
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Controller
class TimelineController {
    @PersistenceContext
    private lateinit var entityManager: EntityManager

    @GetMapping("/")
    fun index(
        model: Model,
        @RequestParam(defaultValue = "20")
        limit: Int,
        @RequestParam(defaultValue = "0")
        offset: Int,
    ): String {
        val posts: List<Post> = entityManager
            .createQuery(
                "SELECT p FROM Post p ORDER BY p.id DESC",
                Post::class.java
            )
            .setFirstResult(offset)
            .setMaxResults(limit).resultList
        model.addAttribute(
            "posts",
            posts
        )
        return "timeline"
    }
}