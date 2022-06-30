package com.ubaya.uas_project_ubaya_library.util

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.ubaya.uas_project_ubaya_library.R
import com.ubaya.uas_project_ubaya_library.model.LibraryDatabase
import java.lang.Exception

val DB_NAME = "newlibrarydb"

fun buildDb(context: Context) = Room.databaseBuilder(context,
    LibraryDatabase::class.java, "newlibrarydb").addMigrations(MIGRATION_1_2  ).build()

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(" ALTER TABLE todo ADD COLUMN priority INTEGER DEFAULT 3 NOT NULL")
    }
}

@BindingAdapter("android:imageUrl", "android:progressBar")
fun loadImageUrl(view: ImageView, url: String?, progressBar: ProgressBar){
    if(url != ""){
        view.loadImage(url, progressBar)
    }
}

fun ImageView.loadImage(url: String?, progressBar: ProgressBar){
    Picasso.get()
        .load(url)
        .resize(400, 400)
        .centerCrop()
        .error(R.drawable.ic_baseline_error_24)
        .into(this, object : Callback {
            override fun onSuccess() {
                progressBar.visibility = View.GONE
            }
            override fun onError(e: Exception?) {
            }
        })
}