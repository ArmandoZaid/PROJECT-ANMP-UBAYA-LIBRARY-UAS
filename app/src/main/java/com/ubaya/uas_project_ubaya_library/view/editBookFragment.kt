package com.ubaya.uas_project_ubaya_library.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.ubaya.uas_project_ubaya_library.R
import com.ubaya.uas_project_ubaya_library.databinding.FragmentEditBookBinding
import com.ubaya.uas_project_ubaya_library.model.Library
import com.ubaya.uas_project_ubaya_library.viewModel.DetailBookViewModel


class editBookFragment : Fragment(), SaveUpdateBookListener {

    private lateinit var viewModel: DetailBookViewModel
    private lateinit var dataBinding: FragmentEditBookBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(inflater, R.layout
            .fragment_edit_book, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DetailBookViewModel::class.java)
        val id = editBookFragmentArgs.fromBundle(requireArguments()).id
        viewModel.fetch(id)

        observeViewModel()
        dataBinding.saveUpdateListener = this
    }

    private fun observeViewModel() {
        viewModel.bookLD.observe(viewLifecycleOwner){
            dataBinding.book = it
        }
    }

    override fun onSaveUpdateBookListener(view: View, obj: Library) {
        viewModel.update(obj)
        Toast.makeText(view.context, "Book updated", Toast.LENGTH_SHORT).show()
        Navigation.findNavController(view).popBackStack()
    }

}