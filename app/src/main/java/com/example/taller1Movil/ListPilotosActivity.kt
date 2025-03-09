package com.example.taller1Movil

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.taller1Movil.adapters.DriverAdapter
import com.example.taller1Movil.databinding.ActivityListPilotosBinding
import com.example.tuapp.models.Driver
import org.json.JSONArray

class ListPilotosActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListPilotosBinding
    private var drivers = mutableListOf<Driver>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListPilotosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Llamamos la función para cargar los pilotos
        loadFromURL()
        binding.listPilotos.setOnItemClickListener { _, _, position, _ ->
            val selectedDriver = drivers[position]

            val intent = Intent(this, PilotActivity::class.java)
            Log.d("DEBUG", "Enviando driver: $selectedDriver")
            intent.putExtra("driver", selectedDriver)
            startActivity(intent)

        }
    }

    private fun loadFromURL() {
        val queue = Volley.newRequestQueue(this)
        val url = "https://api.openf1.org/v1/drivers?session_key=9684" // Testing 2025

        val req = StringRequest(url, Response.Listener { response ->
            try {
                drivers.clear() // Limpiar la lista antes de agregar nuevos datos
                val json = JSONArray(response)

                for (i in 0 until json.length()) {
                    val jsonObject = json.getJSONObject(i)
                    val driver = Driver(
                        driverNumber = jsonObject.getInt("driver_number"),
                        fullName = jsonObject.getString("full_name"),
                        firstName = jsonObject.getString("first_name"),
                        lastName = jsonObject.getString("last_name"),
                        countryCode = jsonObject.optString("country_code", "N/A"), // Puede no existir
                        teamName = jsonObject.optString("team_name", "N/A"),
                        teamColour = jsonObject.optString("team_colour", "#FFFFFF"),
                        headshotUrl = jsonObject.optString("headshot_url", ""),
                        nameAcronym = jsonObject.optString("name_acronym", "N/a")
                    )
                    drivers.add(driver)
                }
                val adapter = DriverAdapter(this, drivers)
                binding.listPilotos.adapter = adapter
            } catch (e: Exception) {
                Log.e("RESTF1", "Error parsing JSON", e)
            }
        }, Response.ErrorListener { error ->
            Log.e("RESTF1", "Error in API Request: ${error.message}")
            Toast.makeText(this, "Error al cargar los datos", Toast.LENGTH_SHORT).show()
        })

        queue.add(req)
    }
}
