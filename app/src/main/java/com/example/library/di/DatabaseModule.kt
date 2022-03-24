package com.example.library.di

import android.content.Context
import androidx.room.Room
import com.example.library.data.database.AuthorDao
import com.example.library.data.database.AuthorWithBookDao
import com.example.library.data.database.BookDao
import com.example.library.data.database.LibraryDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): LibraryDatabase =
        Room.databaseBuilder(
            context,
            LibraryDatabase::class.java,
            "library_db"
        ).build()

    @Provides
    fun provideBookAuthorDao(database: LibraryDatabase): AuthorWithBookDao =
        database.getBookAuthorDao()

    @Provides
    fun provideBookDao(database: LibraryDatabase): BookDao = database.getBookDao()

    @Provides
    fun provideAuthorDao(database: LibraryDatabase): AuthorDao = database.authorDao()

}

