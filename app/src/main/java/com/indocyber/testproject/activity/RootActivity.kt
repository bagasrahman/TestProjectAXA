package com.indocyber.testproject.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.indocyber.testproject.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RootActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.root_activity_layout)
    }
}