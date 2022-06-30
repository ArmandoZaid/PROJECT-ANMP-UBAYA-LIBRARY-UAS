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

class BookListViewModel (application: Application) : AndroidViewModel (application),
CoroutineScope {
    val bookLD = MutableLiveData<List<Library>>()
    val bookLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    private var job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    fun refresh() {
        bookLoadErrorLD.value = false
        loadingLD.value = true
        launch {
            val db = buildDb(getApplication())
            bookLD.value = db.libraryDao().selectAllLibrary()
        }
    }
}