package com.indocyber.testproject

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ProjectApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Thread.setDefaultUncaughtExceptionHandler { thread, exception ->
            Log.e("Apps Error", "Error System", Exception())
        }
    }
}