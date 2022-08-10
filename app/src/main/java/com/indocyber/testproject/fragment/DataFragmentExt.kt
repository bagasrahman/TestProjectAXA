package com.indocyber.testproject.fragment

import android.util.Log
import androidx.core.widget.addTextChangedListener
import com.indocyber.common.AppResponse
import com.indocyber.common.ResponseError
import com.indocyber.common.ResponseLoading
import com.indocyber.common.ResponseSuccess
import java.util.Arrays.toString

fun DataFragment.observeLiveData() = with(vm) {

//    observeResponseData(
//        data, success = {
//            adapter.submitData(it)
//        }, error = {}, loading = {}
//    )

    data.observe(this@observeLiveData) {
        it.data?.let { data1 ->
            Log.i("data", data1.toString())
            adapter.submitData(data1)
        }
    }
}

