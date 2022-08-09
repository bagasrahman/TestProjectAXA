package com.indocyber.testproject.fragment

fun DataFragment.observeLiveData() = with(vm) {

    data.observe(this@observeLiveData){
    }

}