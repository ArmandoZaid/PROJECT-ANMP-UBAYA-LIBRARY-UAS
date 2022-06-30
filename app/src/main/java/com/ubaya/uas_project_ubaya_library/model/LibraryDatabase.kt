package com.ubaya.uas_project_ubaya_library.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ubaya.uas_project_ubaya_library.util.MIGRATION_1_2


@Database(entities = arrayOf(Library::class), version = 2)
abstract class LibraryDatabase:RoomDatabase() {
    abstract fun libraryDao(): LibraryDao

    companion object{
        @Volatile private var instance: LibraryDatabase ?= null
        private val LOCK = Any()

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                LibraryDatabase::class.java,
                "newlibrarydb"
            ).addMigrations(MIGRATION_1_2).build()

        operator fun invoke(context: Context){
            if(instance != null) {
                synchronized(LOCK) {
                    instance ?: buildDatabase(context).also {
                        instance = it
                    }
                }
            }
        }
    }
}