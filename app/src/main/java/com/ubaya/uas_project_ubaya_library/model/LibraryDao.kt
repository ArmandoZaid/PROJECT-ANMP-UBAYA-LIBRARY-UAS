package com.ubaya.uas_project_ubaya_library.model

import androidx.room.*

@Dao
interface LibraryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg library: Library)

    @Query("SELECT * FROM library ORDER BY rating DESC")
    suspend fun selectAllLibrary(): List<Library>

    @Query("SELECT * FROM library WHERE id= :id")
    suspend fun selectLibrary(id:Int): Library

    @Query( "UPDATE library SET title = :title, description =:description, author =:author, rating =:rating, url =:url WHERE id = :id")
    suspend fun update(id:Int, title:String,description:String, author:String, rating:Int, url:String)

    @Update
    suspend fun update(library: Library)

    @Delete
    suspend fun delete(library: Library)

}