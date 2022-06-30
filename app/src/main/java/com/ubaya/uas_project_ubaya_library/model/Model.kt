package com.ubaya.uas_project_ubaya_library.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Library(
    @ColumnInfo(name = "title")
    var title:String,
    @ColumnInfo(name = "description")
    var description:String,
    @ColumnInfo(name = "author")
    var author:String,
    @ColumnInfo(name = "rating")
    var rating:Int,
    @ColumnInfo(name = "url")
    var url:String
    ) {
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}