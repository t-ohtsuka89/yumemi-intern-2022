package com.example.demo.app.controller


import com.example.demo.domain.entity.Post
import com.example.demo.domain.repository.PostRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Controller // This means that this class is a Controller
@RequestMapping(path = ["/post"]) // This means URL's start with /demo (after Application path)
class PostController {
    @Autowired
    lateinit var postRepository: PostRepository

    @PersistenceContext
    private lateinit var entityManager: EntityManager

    @PostMapping
    @ResponseBody
    fun addPost(
        @RequestParam userId: Int, @RequestParam text: String
    ): String {
        val post = Post()
        post.userId = userId
        post.text = text
        postRepository.save(post)
        return "Saved"
    }

    // This returns a JSON or XML with the users
    @GetMapping
    @ResponseBody
    fun getPosts(
        @RequestParam(required = true, defaultValue = "20") limit: Int,
        @RequestParam(required = true, defaultValue = "0") offset: Int
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