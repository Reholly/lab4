package com.example.lab4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lab4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager
            .beginTransaction()
            .replace(binding.mainContent.id, com.example.lab4.recycler.Root())
            .commit()
    }
}