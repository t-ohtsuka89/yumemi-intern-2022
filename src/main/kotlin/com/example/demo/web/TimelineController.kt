package com.example.demo.web

import com.example.demo.PostForTimeline
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import java.util.Date
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
        val tmp = entityManager
            .createNativeQuery(
                "SELECT  p.id, u.username, p.user_id, p.text, p.created_at, p.updated_at FROM posts p INNER JOIN users u ON p.user_id = u.id ORDER BY p.id DESC LIMIT :limit OFFSET :offset",
            )
            .setParameter(
                "limit",
                limit
            )
            .setParameter(
                "offset",
                offset
            ).resultList

        val posts: List<PostForTimeline> = tmp.map {
            val row = it as Array<*>
            PostForTimeline(
                id = row[0] as Int,
                username = row[1] as String,
                userId = row[2] as Int,
                text = row[3] as String,
                createdAt = row[4] as Date,
                updatedAt = row[5] as Date,
            )
        }

        model.addAttribute(
            "posts",
            posts
        )
        return "timeline"
    }
}