package com.ubaya.uas_project_ubaya_library.view

import android.view.View
import com.ubaya.uas_project_ubaya_library.model.Library

interface CreateBookListener {
    fun onCreateBookClick(view: View, obj: Library)
}

interface DetailBookListener{}