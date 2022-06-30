package com.ubaya.uas_project_ubaya_library.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubaya.uas_project_ubaya_library.R
import com.ubaya.uas_project_ubaya_library.viewModel.BookListViewModel
import kotlinx.android.synthetic.main.fragment_list_books.*


class ListFragmentBooks : Fragment() {
    private lateinit var viewModel: BookListViewModel
    private val librarylistAdapter = LibraryListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_books, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(BookListViewModel::class.java)
        viewModel.refresh()

        recViewBooks.layoutManager = LinearLayoutManager(context)
        recViewBooks.adapter = librarylistAdapter

        fabAddBook.setOnClickListener {
            val action = ListFragmentBooksDirections.actionCreateBookFragment()
            Navigation.findNavController(it).navigate(action)
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.bookLD.observe(viewLifecycleOwner) {
            librarylistAdapter.updateBookList(it)

        }
    }

}