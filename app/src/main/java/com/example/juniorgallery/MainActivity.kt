package com.example.juniorgallery

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.NavHost
import androidx.navigation.ui.setupWithNavController
import com.example.juniorgallery.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_JuniorGallery)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            val navHostFragment = supportFragmentManager.findFragmentById(R.id.containerFragment) as NavHost
            bnView.setupWithNavController(navHostFragment.navController)
        }

    }
}