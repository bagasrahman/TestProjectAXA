package com.indocyber.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

abstract class BaseFragment<VM: BaseViewModel, Binding: ViewDataBinding> : Fragment(){
    abstract val vm: VM
    lateinit var binding: Binding
    abstract val layoutResourceId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parentFragment?.let {
            if (it is BaseFragment<*, *>) {
                vm.parent = it.vm
            }
        }
        vm.navigationtEvent.observe(this) {
            findNavController().navigate(it)
        }
    }

    open fun initBinding(binding: Binding){}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<Binding>(
            inflater, layoutResourceId, container, false
        )
        binding.setVariable(BR.vm, vm)
        binding.lifecycleOwner = this
        initBinding(binding)
        return binding.root
    }
}