package com.jetbrains.marco.springbootkotlinreact.controller

import com.jetbrains.marco.springbootkotlinreact.db.Article
import com.jetbrains.marco.springbootkotlinreact.db.ArticleRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException


@RestController
@RequestMapping("/api/v1/articles")
class ArticleController(private val repository: ArticleRepository) {

    @GetMapping
    fun articles() = repository.findAllByOrderByAddedAtDesc()

    @GetMapping("/{id}")
    fun article(@PathVariable id: Long) =
        repository.findById(id).orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) };

    @PostMapping
    fun newArticle(@RequestBody article: Article) = repository.save(article)

    @PutMapping("/{id}")
    fun updateArticle(@RequestBody article: Article, @PathVariable id: Long)=
        repository.findById(id).map {
            it.content = article.content
            it.headline = article.headline
            it.title = article.title
            repository.save(it)
        }.orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) };


    @DeleteMapping("/{id}")
    fun deleteArticle(id: Long) = repository.deleteById(id)
}

// @RestController
// class AnotherRestController...