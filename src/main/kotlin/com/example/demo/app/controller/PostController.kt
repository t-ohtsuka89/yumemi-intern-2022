package com.example.demo.app.controller


import com.example.demo.domain.entity.Post
import com.example.demo.domain.repository.PostRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Controller
@RequestMapping(path = ["/post"])
class PostController(private val postRepository: PostRepository) {
    @PersistenceContext
    private lateinit var entityManager: EntityManager

    @PostMapping
    @ResponseBody
    fun addPost(
        @RequestParam userId: Int,
        @RequestParam text: String
    ): String {
        val post = Post(
            userId = userId,
            text = text,
        )
        postRepository.save(post)
        return "Saved"
    }

    @GetMapping
    @ResponseBody
    fun getPosts(
        @RequestParam(defaultValue = "20") limit: Int,
        @RequestParam(defaultValue = "0") offset: Int
    ): HashMap<String, Any> {
        val resultList = entityManager
            .createNativeQuery("SELECT user_id, text, created_at FROM posts")
            .setFirstResult(offset)
            .setMaxResults(limit)
            .resultList
        val map = HashMap<String, Any>()
        map["posts"] = resultList
        return map
    }


}