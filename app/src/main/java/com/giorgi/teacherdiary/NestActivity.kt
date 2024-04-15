package com.giorgi.teacherdiary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.giorgi.teacherdiary.databinding.ActivityNestBinding

class NestActivity : AppCompatActivity() {

    lateinit var binding: ActivityNestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNestBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}