package com.indocyber.common

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.navigation.NavDirections

open class BaseViewModel(application: Application) : AndroidViewModel(application) {
    val navigationtEvent = SingleLiveEvent<NavDirections>()
    var parent:BaseViewModel? = null
    fun navigate(nav: NavDirections) {
        navigationtEvent.postValue(nav)
    }
}