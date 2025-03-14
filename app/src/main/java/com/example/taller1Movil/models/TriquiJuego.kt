package com.example.taller1Movil.models

class TriquiJuego {

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
            // Si la jugada es valida, se actualiza la casilla y se verifica si el jugador actual ganó
            tablero[posicion] = jugadorActual
            verificarGanador()
            // Se actualiza el turno al otro jugador
            jugadorActual = if (jugadorActual == "X") "O" else "X"
            return true
        }
        return false
    }

    fun getTablero(): Array<String> = tablero
    fun getJugadorActual(): String = jugadorActual
    fun getGanador(): String? = ganador
    fun getCombinacionGanadora(): Array<Int>? = combinacionGanadora

    // Restablece el tablero y las variables relacionadas ganador
    fun reiniciarJuego() {
        tablero = arrayOf("N", "N", "N", "N", "N", "N", "N", "N", "N")
        jugadorActual = "X"
        ganador = null
        combinacionGanadora = null
    }

    // Se definen las combinaciones ganadores en un arreglo de arreglos
    private fun verificarGanador() {
        val combinacionesGanadoras = arrayOf(
            arrayOf(0, 1, 2), arrayOf(3, 4, 5), arrayOf(6, 7, 8), // Horizontales
            arrayOf(0, 3, 6), arrayOf(1, 4, 7), arrayOf(2, 5, 8), // Verticales
            arrayOf(0, 4, 8), arrayOf(2, 4, 6) // Diagonales
        )

        // Se recorre cada combinacion ganadora
        for (combinacion in combinacionesGanadoras) {
            // Se verifica si todas las casillas de la combinacion tienen el mismo valor
            if (tablero[combinacion[0]] != "N" &&
                tablero[combinacion[0]] == tablero[combinacion[1]] &&
                tablero[combinacion[1]] == tablero[combinacion[2]]) {
                // Si se encuentra una combinación ganadora, esta se guarda junto a su ganador
                ganador = tablero[combinacion[0]]
                combinacionGanadora = combinacion
                return
            }
        }
    }
}