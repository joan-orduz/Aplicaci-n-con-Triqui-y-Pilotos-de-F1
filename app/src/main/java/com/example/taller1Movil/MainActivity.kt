package com.example.taller1Movil

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.taller1Movil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.triqui.setOnClickListener {
            startActivity(Intent(baseContext, TriquiActivity::class.java))
        }
        binding.f1.setOnClickListener {
            startActivity(Intent(baseContext, ListPilotosActivity::class.java))
        }
    }
}
