package com.example.taller1Movil

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.taller1Movil.databinding.ActivityTriquiBinding
import com.example.taller1Movil.models.TriquiJuego

class TriquiActivity : AppCompatActivity() {
    private lateinit var binding : ActivityTriquiBinding;
    private val juego = TriquiJuego()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTriquiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        updateUI()
        val casillas = arrayOf(binding.casilla1, binding.casilla2, binding.casilla3, binding.casilla4, binding.casilla5, binding.casilla6, binding.casilla7, binding.casilla8, binding.casilla9)
        casillas.forEachIndexed { indice, casilla ->
            casilla.setOnClickListener {
                if (juego.hacerMovimiento(indice)) {
                    updateUI()
                } else {
                    Toast.makeText(this, "Casilla ocupada o juego terminado", Toast.LENGTH_SHORT).show()
                }
            }
        }
        binding.newGame.setOnClickListener {
            juego.reiniciarJuego()
            updateUI()
        }
        binding.menu.setOnClickListener {
            startActivity(Intent(baseContext, MainActivity::class.java))
        }
    }

    // Esta función permite actualizar la interfaz del usuario según los movimientos.
    private fun updateUI() {
        val tablero = juego.getTablero()

        // Obtiene el estado actual del tablero y las casillas
        val casillas = arrayOf(
            binding.casilla1, binding.casilla2, binding.casilla3,
            binding.casilla4, binding.casilla5, binding.casilla6,
            binding.casilla7, binding.casilla8, binding.casilla9
        )

        // Asigna el texto correspondiente a cada casilla según el tablero actual y reestablece el color en caso de que no haya ganador en el momento
        casillas.forEachIndexed { indice, casilla ->
            casilla.text = if (tablero[indice] == "N") "" else tablero[indice]
            casilla.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#409791")) // Reset color
        }

        // Muestra en pantalla de quien es el turno actual
        binding.currentPlayer.text = "Jugador Actual: ${juego.getJugadorActual()}"

        val ganador = juego.getGanador()
        // Verifica si hay un ganador, en caso de que lo haya, cambia el color de las casillas segun cual sea el jugador vencedor
        if (ganador != null) {
            val color = if (ganador == "X") "#E91E63" else "#3F51B5"
            val combinacionGanadora = juego.getCombinacionGanadora()

            if (combinacionGanadora != null) {
                for (indice in combinacionGanadora) {
                    casillas[indice].backgroundTintList = ColorStateList.valueOf(Color.parseColor(color))
                }
            }

            Toast.makeText(this, "El jugador $ganador ganó!", Toast.LENGTH_LONG).show()
        }
    }
}