package com.ubaya.uas_project_ubaya_library.view

import android.view.View
import com.ubaya.uas_project_ubaya_library.model.Library

interface CreateBookListener {
    fun onCreateBookClick(view: View, obj: Library)
}

interface DetailBookListener{
    fun onDetailBookListener(view: View)
}

interface UpdateBookListener{
    fun onUpdateBookListener(view: View)
}

interface SaveUpdateBookListener {
    fun onSaveUpdateBookListener(view: View, obj: Library)
}

interface DeleteBookListener{
    fun onDeleteBookListener(view: View)
}