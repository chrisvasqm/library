package com.example.library.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

data class AuthorWithBook(
    @Embedded val author: Author,
    @Relation(parentColumn = "authorId", entityColumn = "authorId") val books: List<Book>
)