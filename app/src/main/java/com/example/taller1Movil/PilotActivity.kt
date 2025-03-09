package com.example.taller1Movil

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.taller1Movil.databinding.ActivityPilotBinding
import com.example.tuapp.models.Driver

class PilotActivity : AppCompatActivity() {
    private lateinit var driver : Driver
    private lateinit var binding : ActivityPilotBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPilotBinding.inflate(layoutInflater)
        setContentView(binding.root)
        driver = intent.getParcelableExtra<Driver>("driver") ?: throw IllegalStateException("No se encontró el piloto")
        binding.
    }
}