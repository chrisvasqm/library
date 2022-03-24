package com.example.library

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.library.data.database.AuthorDao
import com.example.library.data.database.AuthorWithBookDao
import com.example.library.data.database.BookDao
import com.example.library.data.database.LibraryDatabase
import com.example.library.data.model.Author
import com.example.library.data.model.Book
import com.google.common.truth.Truth.*
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AuthorWithBookDaoTests {
    private lateinit var database: LibraryDatabase
    private lateinit var authorWithBookDao: AuthorWithBookDao
    private lateinit var bookDao: BookDao
    private lateinit var authorDao: AuthorDao

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(context, LibraryDatabase::class.java).build()
        authorWithBookDao = database.getBookAuthorDao()
        bookDao = database.getBookDao()
        authorDao = database.authorDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun getAll_NoDataHasBeenSaved_ReturnsEmptyList() = runBlocking {
        val actual = authorWithBookDao.getAll()

        assertThat(actual).isEmpty()
    }

    @Test
    fun getAll_WhenDataHasBeenSaved_ReturnsAuthorWithAllBooks() = runBlocking {
        val author = Author(authorId = 1, firstName = "f", lastName = "l")
        authorDao.insert(author)
        val book = Book(coverImage = byteArrayOf(), title = "t", description = "d", authorId = author.authorId)
        bookDao.insert(book)

        val actual = authorWithBookDao.getAll()

        assertThat(actual).isNotEmpty()
    }
}