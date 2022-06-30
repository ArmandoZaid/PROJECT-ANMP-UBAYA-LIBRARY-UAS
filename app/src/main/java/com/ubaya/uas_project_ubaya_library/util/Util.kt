package com.ubaya.uas_project_ubaya_library.util

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ubaya.uas_project_ubaya_library.model.LibraryDatabase

val DB_NAME = "newlibrarydb"

fun buildDb(context: Context) = Room.databaseBuilder(context,
    LibraryDatabase::class.java, "newlibrarydb").addMigrations(MIGRATION_1_2  ).build()

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(" ALTER TABLE todo ADD COLUMN priority INTEGER DEFAULT 3 NOT NULL")
    }

}