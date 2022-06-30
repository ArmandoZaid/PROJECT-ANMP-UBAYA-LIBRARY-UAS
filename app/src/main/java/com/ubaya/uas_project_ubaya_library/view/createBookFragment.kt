package com.ubaya.uas_project_ubaya_library.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.ubaya.uas_project_ubaya_library.R
import com.ubaya.uas_project_ubaya_library.databinding.FragmentCreateBookBinding
import com.ubaya.uas_project_ubaya_library.model.Library
import com.ubaya.uas_project_ubaya_library.viewModel.BookListViewModel
import com.ubaya.uas_project_ubaya_library.viewModel.DetailBookViewModel


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
        viewModel.bookLD.observe(viewLifecycleOwner) {
            dataBinding.book = it
        }
    }

    override fun onCreateBookClick(
        view: View,
        obj: List<Library>,
    ){
        viewModel.addTodo(obj)
        Toast.makeText(view.context, "Todo updated", Toast.LENGTH_SHORT).show()
        Navigation.findNavController(view).popBackStack()
    }

}