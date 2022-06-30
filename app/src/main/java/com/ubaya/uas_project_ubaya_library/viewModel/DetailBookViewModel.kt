package com.ubaya.uas_project_ubaya_library.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.ubaya.uas_project_ubaya_library.model.Library
import com.ubaya.uas_project_ubaya_library.util.buildDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class DetailBookViewModel(application: Application) :
AndroidViewModel(application), CoroutineScope{

    private val job = Job()
    val bookLD = MutableLiveData<Library>()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    fun addTodo(todoList: List<Library>){
        launch {
            val db = buildDb(getApplication())
            db.libraryDao().insertAll(*todoList.toTypedArray())
        }
    }

    fun fetch(id: Int){
        launch {
            val db = buildDb(getApplication())
            bookLD.value = db.libraryDao().selectLibrary(id)
        }
    }

    fun update(book: Library){
        launch {
            val db = buildDb(getApplication())
            db.libraryDao().update(book)
        }
    }
}