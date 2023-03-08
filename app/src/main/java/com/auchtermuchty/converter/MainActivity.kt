package com.auchtermuchty.converter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.auchtermuchty.converter.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)

    }
}