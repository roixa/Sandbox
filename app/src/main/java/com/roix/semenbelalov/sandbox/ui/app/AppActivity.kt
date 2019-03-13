package com.roix.semenbelalov.sandbox.ui.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.roix.semenbelalov.sandbox.R

//this it root activity, container of navigation only
class AppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)
    }
}
