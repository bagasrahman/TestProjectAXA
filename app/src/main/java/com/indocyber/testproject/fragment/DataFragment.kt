package com.indocyber.testproject.fragment

import androidx.fragment.app.viewModels
import com.indocyber.common.BaseFragment
import com.indocyber.testproject.R
import com.indocyber.testproject.databinding.DataLayoutBinding
import com.indocyber.testproject.view_model.DataViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DataFragment : BaseFragment<DataViewModel, DataLayoutBinding>(){
    override val vm: DataViewModel by viewModels()
    override val layoutResourceId: Int = R.layout.data_layout
    val adapter = DataAdapter()

    override fun initBinding(binding: DataLayoutBinding) {
        super.initBinding(binding)
        binding.rvData.adapter = adapter

    }
}