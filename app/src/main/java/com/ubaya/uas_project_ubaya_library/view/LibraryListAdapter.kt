package com.ubaya.uas_project_ubaya_library.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.uas_project_ubaya_library.databinding.BooksItemLayoutBinding
import com.ubaya.uas_project_ubaya_library.model.Library

class LibraryListAdapter (val bookList : ArrayList<Library>):
    RecyclerView.Adapter<LibraryListAdapter.LibraryViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibraryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = BooksItemLayoutBinding.inflate(inflater, parent, false)

        return LibraryViewHolder(view, parent.context )
    }

    fun updateBookList(newTodoList: List<Library>) {
        bookList.clear()
        bookList.addAll(newTodoList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: LibraryViewHolder, position: Int) {
        val book = bookList[position]

          holder.bind(book)
//        holder.view.book = bookList[position]
    }

    override fun getItemCount(): Int = bookList.size

    class LibraryViewHolder (val binding: BooksItemLayoutBinding, val context: Context) :
        RecyclerView.ViewHolder(binding.root){

            fun bind(book : Library){
                binding.book = book
            }
        }
}
