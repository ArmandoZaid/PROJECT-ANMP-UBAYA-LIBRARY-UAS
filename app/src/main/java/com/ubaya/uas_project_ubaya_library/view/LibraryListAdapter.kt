package com.ubaya.uas_project_ubaya_library.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.uas_project_ubaya_library.databinding.BooksItemLayoutBinding
import com.ubaya.uas_project_ubaya_library.model.Library

class LibraryListAdapter (val bookList : ArrayList<Library>) :
    RecyclerView.Adapter<LibraryListAdapter.LibraryViewHolder>() {
    class LibraryViewHolder(var view: BooksItemLayoutBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibraryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = BooksItemLayoutBinding.inflate(inflater, parent, false)

        return LibraryViewHolder(view)
    }

    fun updateBookList(newTodoList: List<Library>) {
        bookList.clear()
        bookList.addAll(newTodoList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: LibraryViewHolder, position: Int) {
        val book = bookList[position]
        holder.view.book = bookList[position]
    }

    override fun getItemCount(): Int = bookList.size
}
