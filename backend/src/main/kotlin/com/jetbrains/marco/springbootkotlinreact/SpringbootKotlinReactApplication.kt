package com.jetbrains.marco.springbootkotlinreact

import com.jetbrains.marco.springbootkotlinreact.db.Article
import com.jetbrains.marco.springbootkotlinreact.db.ArticleRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class SpringbootKotlinReactApplication {

    @Bean
    fun databaseInitializer(articleRepository: ArticleRepository) = ApplicationRunner {
        articleRepository.deleteAllInBatch();

        articleRepository.save(
            Article(
                title = "My first blogpost",
                headline = "This is great!",
                content = "The first article's awesome text!",
                author = "Marco"
            )
        )
        articleRepository.save(
            Article(
                title = "My Second Blogpost",
                headline = "This is even better",
                content = "The second article's awesome text!",
                author = "John"
            )
        )
    }
}

fun main(args: Array<String>) {
    runApplication<SpringbootKotlinReactApplication>(*args)
}
