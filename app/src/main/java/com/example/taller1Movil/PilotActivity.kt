package com.example.taller1Movil

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.example.taller1Movil.databinding.ActivityPilotBinding
import com.example.tuapp.models.Driver
import org.json.JSONArray

// Utilice glide para poner las imagenes, me permite colocar imagen para cuando esta cargando y para cuando hay un error
class PilotActivity : AppCompatActivity() {
    private lateinit var binding : ActivityPilotBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPilotBinding.inflate(layoutInflater)
        Log.d("PilotActivity", "Se inició")
        setContentView(binding.root)
        val driver:Driver? = intent?.getParcelableExtra<Driver>("driver")
            ?: throw IllegalStateException("No se encontró el piloto")
        if(driver!= null){
            Log.d("DEBUG", "Recibido driver: $driver")
            binding.nombre.text = driver.fullName
            binding.equipo.text = driver.teamName
            binding.equipo.setTextColor(Color.parseColor("#${driver.teamColour}"))
            binding.acronimo.text = driver.nameAcronym
            Glide.with(this)
                .load(driver.headshotUrl)
                .placeholder(R.drawable.loading)
                .error(R.drawable.error)
                .into(binding.pilotoImagen)
            loadFlag(driver)
        }

    }

    private fun loadFlag(driver: Driver) {

        // Si el piloto no tiene la nacionalidad registrada en la API se muestra una imagen del planeta tierra
        if (driver.countryCode.isNullOrEmpty() || driver.countryCode == "null") {
            Glide.with(this)
                .load(R.drawable.planeta)
                .into(binding.nacionalidad)
            return        }

        val queue = Volley.newRequestQueue(this)
        val url = "https://restcountries.com/v3.1/alpha/${driver.countryCode}"

        val req = StringRequest(url, Response.Listener { response ->
            try {
                val jsonArray = JSONArray(response)
                if (jsonArray.length() > 0) {
                    val jsonObject = jsonArray.getJSONObject(0)
                    val flagUrl = jsonObject.getJSONObject("flags").optString("png", "")

                    if (flagUrl.isNotEmpty()) {
                        Glide.with(this)
                            .load(flagUrl)
                            .placeholder(R.drawable.loading)
                            .error(R.drawable.error)
                            .into(binding.nacionalidad) // Asegúrate de tener un ImageView en tu XML con este ID
                    }
                }
            } catch (e: Exception) {
                Log.e("PilotActivity", "Error parsing JSON", e)
            }
        }, Response.ErrorListener { error ->
            Log.e("PilotActivity", "Error in API Request: ${error.message}")
        })

        queue.add(req)
    }


}