package com.example.juniorgallery.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.juniorgallery.R
import com.example.juniorgallery.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_JuniorGallery)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}