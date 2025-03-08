package com.example.triqui

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.triqui.databinding.ActivityMainBinding

class Triqui {

    // Este arreglo representará el tablero, será editado con cada movimiento del jugador X o del jugador O
    private var tablero = arrayOf("N", "N", "N", "N", "N", "N", "N", "N", "N")
    private var jugadorActual = "X"
    // Acá se almacenará el ganador de la partida, empieza en null porque al inicio no hay ganador
    private var ganador: String? = null
    // Este arreglo guarda el index de las casillas ganadoras, lo que permite cambiarles el color cuando haya un ganador
    private var combinacionGanadora: Array<Int>? = null

    fun hacerMovimiento(posicion: Int): Boolean {
        // Primero se verifica si la casilla está vacía y no existe un ganador
        if (tablero[posicion] == "N" && ganador == null) {
            tablero[posicion] = jugadorActual
            verificarGanador()
            jugadorActual = if (jugadorActual == "X") "O" else "X"
            return true
        }
        return false
    }

    fun getTablero(): Array<String> = tablero
    fun getJugadorActual(): String = jugadorActual
    fun getGanador(): String? = ganador
    fun getCombinacionGanadora(): Array<Int>? = combinacionGanadora

    fun reiniciarJuego() {
        tablero = arrayOf("N", "N", "N", "N", "N", "N", "N", "N", "N")
        jugadorActual = "X"
        ganador = null
        combinacionGanadora = null
    }

    private fun verificarGanador() {
        val combinacionesGanadoras = arrayOf(
            arrayOf(0, 1, 2), arrayOf(3, 4, 5), arrayOf(6, 7, 8), // Horizontales
            arrayOf(0, 3, 6), arrayOf(1, 4, 7), arrayOf(2, 5, 8), // Verticales
            arrayOf(0, 4, 8), arrayOf(2, 4, 6) // Diagonales
        )

        for (combinacion in combinacionesGanadoras) {
            if (tablero[combinacion[0]] != "N" &&
                tablero[combinacion[0]] == tablero[combinacion[1]] &&
                tablero[combinacion[1]] == tablero[combinacion[2]]) {
                ganador = tablero[combinacion[0]]
                combinacionGanadora = combinacion
                return
            }
        }
    }
}

class ActividadPrincipal : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val juego = Triqui()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        updateUI()

        val casillas = arrayOf(
            binding.casilla1, binding.casilla2, binding.casilla3,
            binding.casilla4, binding.casilla5, binding.casilla6,
            binding.casilla7, binding.casilla8, binding.casilla9
        )

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
    }

    private fun updateUI() {
        val tablero = juego.getTablero()
        val casillas = arrayOf(
            binding.casilla1, binding.casilla2, binding.casilla3,
            binding.casilla4, binding.casilla5, binding.casilla6,
            binding.casilla7, binding.casilla8, binding.casilla9
        )

        casillas.forEachIndexed { indice, casilla ->
            casilla.text = if (tablero[indice] == "N") "" else tablero[indice]
            casilla.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#409791")) // Reset color
        }

        binding.currentPlayer.text = "Jugador Actual: ${juego.getJugadorActual()}"

        juego.getGanador()?.let { ganador ->
            val color = if (ganador == "X") "#E91E63" else "#3F51B5"
            juego.getCombinacionGanadora()?.forEach { indice ->
                casillas[indice].backgroundTintList = ColorStateList.valueOf(Color.parseColor(color))
            }
            Toast.makeText(this, "El jugador $ganador ganó!", Toast.LENGTH_LONG).show()
        }
    }
}
