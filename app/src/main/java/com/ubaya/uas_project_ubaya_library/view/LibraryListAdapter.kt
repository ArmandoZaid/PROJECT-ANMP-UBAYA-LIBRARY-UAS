package com.ubaya.uas_project_ubaya_library.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.uas_project_ubaya_library.databinding.BooksItemLayoutBinding
import com.ubaya.uas_project_ubaya_library.databinding.FragmentCreateBookBinding
import com.ubaya.uas_project_ubaya_library.model.Library
import com.ubaya.uas_project_ubaya_library.viewModel.DetailBookViewModel

class LibraryListAdapter (val bookList : ArrayList<Library>):
    RecyclerView.Adapter<LibraryListAdapter.LibraryViewHolder>(), DetailBookListener, UpdateBookListener, DeleteBookListener{

    private lateinit var viewModel : DetailBookViewModel

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibraryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = BooksItemLayoutBinding.inflate(inflater, parent, false)

        return LibraryViewHolder(view, parent.context )
    }

    fun updateBookList(newBookList: List<Library>) {
        bookList.clear()
        bookList.addAll(newBookList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: LibraryViewHolder, position: Int) {
        val book = bookList[position]
          holder.bind(book)
        holder.binding.detailListener = this
        holder.binding.updateListener = this
//        holder.view.book = bookList[position]
    }

    override fun getItemCount(): Int = bookList.size

    override fun onDetailBookListener(view: View) {
        val id = view.tag.toString().toInt()
        val act = ListFragmentBooksDirections.actionDetailBookFragment(id)
        Navigation.findNavController(view).navigate(act)
    }



    class LibraryViewHolder (val binding: BooksItemLayoutBinding, val context: Context) :
        RecyclerView.ViewHolder(binding.root){
            fun bind(book : Library){
                binding.book = book
            }
        }

    override fun onUpdateBookListener(view: View) {
        val id = view.tag.toString().toInt()
        val act = ListFragmentBooksDirections.actionEditBookFragment(id)
        Navigation.findNavController(view).navigate(act)
    }

    override fun onDeleteBookListener(view: View){
        val id = view.tag.toString().toInt()
        viewModel.clearRow(bookList[id])
    }

}
