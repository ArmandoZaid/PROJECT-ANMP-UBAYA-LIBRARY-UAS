package com.ubaya.uas_project_ubaya_library.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.ubaya.uas_project_ubaya_library.R
import com.ubaya.uas_project_ubaya_library.databinding.FragmentCreateBookBinding
import com.ubaya.uas_project_ubaya_library.model.Library
import com.ubaya.uas_project_ubaya_library.viewModel.BookListViewModel
import com.ubaya.uas_project_ubaya_library.viewModel.DetailBookViewModel
import kotlinx.android.synthetic.main.fragment_create_book.view.*


class createBookFragment : Fragment(), CreateBookListener {

    private lateinit var dataBinding : FragmentCreateBookBinding
    private lateinit var viewModel : DetailBookViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_create_book,
        container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observiewModel()
        dataBinding.createListener = this
    }

    private fun observiewModel() {
        dataBinding.book = Library( "","","",0)
        viewModel = ViewModelProvider(this).get(DetailBookViewModel::class.java)
    }

    override fun onCreateBookClick(
        view: View,
        obj: Library,
    ){
        var list = listOf(obj)
        var book = listOf(Library( dataBinding.createTitle.text.toString(), dataBinding.createDescription.text.toString(),
            dataBinding.createAuthor.text.toString(), dataBinding.createRating.text.toString().toInt()))
        Log.d("sedfdsfd", dataBinding.createTitle.text.toString());
        viewModel.addTodo(book)
        Toast.makeText(view.context, "Todo updated", Toast.LENGTH_SHORT).show()
        Navigation.findNavController(view).popBackStack()
    }

}