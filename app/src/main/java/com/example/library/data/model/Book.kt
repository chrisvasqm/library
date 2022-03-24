package com.example.library.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books")
data class Book(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "bookId") val bookId: Long = 0,
    @ColumnInfo(name = "cover_image", typeAffinity = ColumnInfo.BLOB) val coverImage: ByteArray,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "authorId") val authorId: Long
)