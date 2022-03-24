package com.example.library.data.database

import androidx.room.Dao
import androidx.room.Insert
import com.example.library.data.model.Book

@Dao
interface BookDao {

    @Insert
    suspend fun insert(book: Book)

}