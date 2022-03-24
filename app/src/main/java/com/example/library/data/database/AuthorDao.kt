package com.example.library.data.database

import androidx.room.Dao
import androidx.room.Insert
import com.example.library.data.model.Author

@Dao
interface AuthorDao {

    @Insert
    suspend fun insert(author: Author)

}