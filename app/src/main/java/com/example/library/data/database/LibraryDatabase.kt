package com.example.library.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.library.data.model.Author
import com.example.library.data.model.Book
import com.example.library.data.model.AuthorWithBook

@Database(entities = [Book::class, Author::class], version = 1)
abstract class LibraryDatabase : RoomDatabase() {

    abstract fun getBookAuthorDao(): AuthorWithBookDao

    abstract fun getBookDao(): BookDao

    abstract fun authorDao(): AuthorDao

}