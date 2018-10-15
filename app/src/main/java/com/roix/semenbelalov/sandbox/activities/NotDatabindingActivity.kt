package com.roix.semenbelalov.sandbox.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.roix.semenbelalov.sandbox.R

class NotDatabindingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_not_databinding)
    }
}
