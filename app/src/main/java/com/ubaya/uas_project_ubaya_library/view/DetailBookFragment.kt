package com.ubaya.uas_project_ubaya_library.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.ubaya.uas_project_ubaya_library.R
import com.ubaya.uas_project_ubaya_library.databinding.FragmentDetailBookBinding
import com.ubaya.uas_project_ubaya_library.viewModel.DetailBookViewModel

class DetailBookFragment : Fragment() {

    private lateinit var viewModel: DetailBookViewModel
    private lateinit var dataBinding: FragmentDetailBookBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(inflater, R.layout
            .fragment_detail_book, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailBookViewModel::class.java)
        val id = DetailBookFragmentArgs.fromBundle(requireArguments()).id
        viewModel.fetch(id)
    }


}