package com.example.library.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.library.data.model.AuthorWithBook

@Dao
interface AuthorWithBookDao {

    @Transaction
    @Query("SELECT * FROM authors a JOIN books b ON a.authorId = b.authorId")
    suspend fun getAll(): List<AuthorWithBook>

}