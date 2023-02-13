package com.jetbrains.marco.springbootkotlinreact.db

import com.jetbrains.marco.springbootkotlinreact.toSlug
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
class Article(
    var title: String?,
    var headline: String?,
    var content: String?,
    var author: String?,
    var slug: String? = title?.toSlug(),
    var addedAt: LocalDateTime = LocalDateTime.now(),
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
)