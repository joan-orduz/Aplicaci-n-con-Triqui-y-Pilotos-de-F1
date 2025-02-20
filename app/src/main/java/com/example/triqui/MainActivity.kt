package com.example.triqui

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.triqui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    var casillas = arrayOf("N","N","N",
                            "N","N","N",
                            "N","N","N")

    /* El turno se definirá por un booleano, si está en true, el turno será
        del jugador X, si es false será el turno del jugador y*/
    var jugadorActual = true
    var ganador = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.currentPlayer.text = "Current Player: X"

        // CASILLA 1
        binding.casilla1.setOnClickListener {
            // Verificar que esté vacía
            if(casillas[0] == "N" && !ganador){

                //Turno del jugador X
                if(jugadorActual){
                    binding.casilla1.text = "X"
                    casillas[0] = "X"
                    Log.i("ArrayCasillas", "${casillas.toString()}")
                    binding.currentPlayer.text = "Current Player: O"
                    jugadorActual = false

                    if((casillas[0] == "X" && casillas[1] == "X" && casillas[2] == "X")){
                        Toast.makeText(baseContext, "EL JUGADOR X GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla1.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla2.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla3.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        ganador = true

                    }else if((casillas[0] == "X" && casillas[4] == "X" && casillas[8] == "X")){
                        Toast.makeText(baseContext, "EL JUGADOR X GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla1.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla5.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla9.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        ganador = true

                    }else if((casillas[0] == "X" && casillas[3] == "X" && casillas[6] == "X")){
                        Toast.makeText(baseContext, "EL JUGADOR X GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla1.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla4.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla7.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        ganador = true
                    }

                // Turno del jugador O
                } else {
                    binding.casilla1.text = "O"
                    casillas[0] = "O"
                    Log.i("ArrayCasillas", "${casillas.toString()}")
                    binding.currentPlayer.text = "Current Player: X"
                    jugadorActual = true;

                    if((casillas[0] == "O" && casillas[1] == "O" && casillas[2] == "O")){
                        Toast.makeText(baseContext, "EL JUGADOR O GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla1.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        binding.casilla2.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        binding.casilla3.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        ganador = true

                    }else if((casillas[0] == "O" && casillas[4] == "O" && casillas[8] == "O")){
                        Toast.makeText(baseContext, "EL JUGADOR O GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla1.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        binding.casilla5.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        binding.casilla9.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        ganador = true

                    }else if((casillas[0] == "O" && casillas[3] == "O" && casillas[6] == "O")){
                        Toast.makeText(baseContext, "EL JUGADOR O GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla1.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        binding.casilla4.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        binding.casilla7.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        ganador = true
                    }
                }
            }else if(ganador){
                Toast.makeText(baseContext, "YA HAY UN GANADOR, PULSA EN New Game PARA JUGAR DE NUEVO 👍", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(baseContext, "ESTA CASILLA YA ESTÁ OCUPADA, INTENTA JUGAR EN OTRA 🤓", Toast.LENGTH_LONG).show()
            }

        }

        //--------------------*--------------------*--------------------*--------------------

        // CASILLA 2
        binding.casilla2.setOnClickListener {
            // Verificar que esté vacía
            if(casillas[1] == "N" && !ganador){

                //Turno del jugador X
                if(jugadorActual){
                    binding.casilla2.text = "X"
                    casillas[1] = "X"
                    Log.i("ArrayCasillas", "${casillas.toString()}")
                    binding.currentPlayer.text = "Current Player: O"
                    jugadorActual = false;

                    if((casillas[0] == "X" && casillas[1] == "X" && casillas[2] == "X")){
                        Toast.makeText(baseContext, "EL JUGADOR X GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla1.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla2.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla3.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        ganador = true

                    }else if((casillas[1] == "X" && casillas[4] == "X" && casillas[7] == "X")){
                        Toast.makeText(baseContext, "EL JUGADOR X GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla2.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla5.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla8.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        ganador = true
                    }

                    // Turno del jugador O
                } else {
                    binding.casilla2.text = "O"
                    casillas[1] = "O"
                    Log.i("ArrayCasillas", "${casillas.toString()}")
                    binding.currentPlayer.text = "Current Player: X"
                    jugadorActual = true;

                    if((casillas[0] == "O" && casillas[1] == "O" && casillas[2] == "O")){
                        Toast.makeText(baseContext, "EL JUGADOR O GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla1.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        binding.casilla2.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        binding.casilla3.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        ganador = true

                    }else if((casillas[1] == "O" && casillas[4] == "O" && casillas[7] == "O")){
                        Toast.makeText(baseContext, "EL JUGADOR O GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla2.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        binding.casilla5.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        binding.casilla8.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        ganador = true
                    }
                }
            }else if(ganador){
                Toast.makeText(baseContext, "YA HAY UN GANADOR, PULSA EN New Game PARA JUGAR DE NUEVO 👍", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(baseContext, "ESTA CASILLA YA ESTÁ OCUPADA, INTENTA JUGAR EN OTRA 🤓", Toast.LENGTH_LONG).show()
            }

        }

        //--------------------*--------------------*--------------------*--------------------

        //CASILLA 3
        binding.casilla3.setOnClickListener {
            // Verificar que esté vacía
            if(casillas[2] == "N" && !ganador){

                //Turno del jugador X
                if(jugadorActual){
                    binding.casilla3.text = "X"
                    casillas[2] = "X"
                    Log.i("ArrayCasillas", "${casillas.toString()}")
                    binding.currentPlayer.text = "Current Player: O"
                    jugadorActual = false;

                    if((casillas[0] == "X" && casillas[1] == "X" && casillas[2] == "X")){
                        Toast.makeText(baseContext, "EL JUGADOR X GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla1.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla2.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla3.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        ganador = true

                    }else if((casillas[2] == "X" && casillas[4] == "X" && casillas[6] == "X")){
                        Toast.makeText(baseContext, "EL JUGADOR X GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla3.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla5.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla7.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        ganador = true

                    }else if((casillas[2] == "X" && casillas[5] == "X" && casillas[8] == "X")){
                        Toast.makeText(baseContext, "EL JUGADOR X GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla3.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla6.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla9.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        ganador = true
                    }

                    // Turno del jugador O
                } else {
                    binding.casilla3.text = "O"
                    casillas[2] = "O"
                    Log.i("ArrayCasillas", "${casillas.toString()}")
                    binding.currentPlayer.text = "Current Player: X"
                    jugadorActual = true;

                    if((casillas[0] == "O" && casillas[1] == "O" && casillas[2] == "O")){
                        Toast.makeText(baseContext, "EL JUGADOR O GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla1.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        binding.casilla2.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        binding.casilla3.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        ganador = true

                    }else if((casillas[2] == "O" && casillas[4] == "O" && casillas[6] == "O")){
                        Toast.makeText(baseContext, "EL JUGADOR O GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla3.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        binding.casilla5.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        binding.casilla7.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        ganador = true

                    }else if((casillas[2] == "O" && casillas[5] == "O" && casillas[8] == "O")){
                        Toast.makeText(baseContext, "EL JUGADOR O GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla3.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        binding.casilla6.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        binding.casilla9.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        ganador = true
                    }
                }
            }else if(ganador){
                Toast.makeText(baseContext, "YA HAY UN GANADOR, PULSA EN New Game PARA JUGAR DE NUEVO 👍", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(baseContext, "ESTA CASILLA YA ESTÁ OCUPADA, INTENTA JUGAR EN OTRA 🤓", Toast.LENGTH_LONG).show()
            }

        }

        //--------------------*--------------------*--------------------*--------------------

        //CASILLA 4
        binding.casilla4.setOnClickListener {
            // Verificar que esté vacía
            if(casillas[3] == "N" && !ganador){

                //Turno del jugador X
                if(jugadorActual){
                    binding.casilla4.text = "X"
                    casillas[3] = "X"
                    Log.i("ArrayCasillas", "${casillas.toString()}")
                    binding.currentPlayer.text = "Current Player: O"
                    jugadorActual = false;

                    if((casillas[3] == "X" && casillas[4] == "X" && casillas[5] == "X")){
                        Toast.makeText(baseContext, "EL JUGADOR X GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla4.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla5.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla6.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        ganador = true

                    }else if((casillas[3] == "X" && casillas[0] == "X" && casillas[6] == "X")){
                        Toast.makeText(baseContext, "EL JUGADOR X GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla3.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla5.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla7.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        ganador = true

                    }

                // Turno del jugador O
                } else {
                    binding.casilla4.text = "O"
                    casillas[3] = "O"
                    Log.i("ArrayCasillas", "${casillas.toString()}")
                    binding.currentPlayer.text = "Current Player: X"
                    jugadorActual = true;

                    if((casillas[3] == "O" && casillas[4] == "O" && casillas[5] == "O")){
                        Toast.makeText(baseContext, "EL JUGADOR O GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla4.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        binding.casilla5.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        binding.casilla6.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        ganador = true

                    }else if((casillas[3] == "O" && casillas[0] == "O" && casillas[6] == "O")){
                        Toast.makeText(baseContext, "EL JUGADOR O GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla3.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        binding.casilla5.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        binding.casilla7.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        ganador = true

                    }
                }
            }else if(ganador){
                Toast.makeText(baseContext, "YA HAY UN GANADOR, PULSA EN New Game PARA JUGAR DE NUEVO 👍", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(baseContext, "ESTA CASILLA YA ESTÁ OCUPADA, INTENTA JUGAR EN OTRA 🤓", Toast.LENGTH_LONG).show()
            }

        }

        //--------------------*--------------------*--------------------*--------------------

        //CASILLA 5
        binding.casilla5.setOnClickListener {
            // Verificar que esté vacía
            if(casillas[4] == "N" && !ganador){

                //Turno del jugador X
                if(jugadorActual){
                    binding.casilla5.text = "X"
                    casillas[4] = "X"
                    Log.i("ArrayCasillas", "${casillas.toString()}")
                    binding.currentPlayer.text = "Current Player: O"
                    jugadorActual = false;

                    if((casillas[0] == "X" && casillas[4] == "X" && casillas[8] == "X")){
                        Toast.makeText(baseContext, "EL JUGADOR X GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla1.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla5.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla9.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        ganador = true

                    }else if((casillas[1] == "X" && casillas[4] == "X" && casillas[7] == "X")){
                        Toast.makeText(baseContext, "EL JUGADOR X GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla2.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla5.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla8.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        ganador = true

                    }else if((casillas[2] == "X" && casillas[4] == "X" && casillas[6] == "X")){
                        Toast.makeText(baseContext, "EL JUGADOR X GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla3.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla5.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla7.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        ganador = true

                    }else if((casillas[3] == "X" && casillas[4] == "X" && casillas[5] == "X")){
                        Toast.makeText(baseContext, "EL JUGADOR X GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla4.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla5.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla6.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        ganador = true
                    }

                    // Turno del jugador O
                } else {
                    binding.casilla5.text = "O"
                    casillas[4] = "O"
                    Log.i("ArrayCasillas", "${casillas.toString()}")
                    binding.currentPlayer.text = "Current Player: X"
                    jugadorActual = true;

                    if((casillas[0] == "O" && casillas[4] == "O" && casillas[8] == "O")){
                        Toast.makeText(baseContext, "EL JUGADOR O GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla1.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla5.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla9.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        ganador = true

                    }else if((casillas[1] == "O" && casillas[4] == "O" && casillas[7] == "O")){
                        Toast.makeText(baseContext, "EL JUGADOR O GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla2.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla5.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla8.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        ganador = true

                    }else if((casillas[2] == "O" && casillas[4] == "O" && casillas[6] == "O")){
                        Toast.makeText(baseContext, "EL JUGADOR O GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla3.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla5.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla7.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        ganador = true

                    }else if((casillas[3] == "O" && casillas[4] == "O" && casillas[5] == "O")){
                        Toast.makeText(baseContext, "EL JUGADOR O GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla4.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla5.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla6.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        ganador = true
                    }
                }
            }else if(ganador){
                Toast.makeText(baseContext, "YA HAY UN GANADOR, PULSA EN New Game PARA JUGAR DE NUEVO 👍", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(baseContext, "ESTA CASILLA YA ESTÁ OCUPADA, INTENTA JUGAR EN OTRA 🤓", Toast.LENGTH_LONG).show()
            }

        }

        //--------------------*--------------------*--------------------*--------------------

        //CASILLA 6
        binding.casilla6.setOnClickListener {
            // Verificar que esté vacía
            if(casillas[5] == "N" && !ganador){

                //Turno del jugador X
                if(jugadorActual){
                    binding.casilla6.text = "X"
                    casillas[5] = "X"
                    Log.i("ArrayCasillas", "${casillas.toString()}")
                    binding.currentPlayer.text = "Current Player: O"
                    jugadorActual = false;

                    if((casillas[2] == "X" && casillas[5] == "X" && casillas[8] == "X")){
                        Toast.makeText(baseContext, "EL JUGADOR X GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla3.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla6.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla9.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        ganador = true

                    }else if((casillas[3] == "X" && casillas[4] == "X" && casillas[5] == "X")){
                        Toast.makeText(baseContext, "EL JUGADOR X GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla4.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla5.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla6.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        ganador = true

                    }

                    // Turno del jugador O
                } else {
                    binding.casilla6.text = "O"
                    casillas[5] = "O"
                    Log.i("ArrayCasillas", "${casillas.toString()}")
                    binding.currentPlayer.text = "Current Player: X"
                    jugadorActual = true;

                    if((casillas[2] == "O" && casillas[5] == "O" && casillas[8] == "O")){
                        Toast.makeText(baseContext, "EL JUGADOR O GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla3.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        binding.casilla6.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        binding.casilla9.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        ganador = true

                    }else if((casillas[3] == "O" && casillas[4] == "O" && casillas[5] == "O")){
                        Toast.makeText(baseContext, "EL JUGADOR O GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla4.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        binding.casilla5.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        binding.casilla6.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        ganador = true

                    }
                }
            }else if(ganador){
                Toast.makeText(baseContext, "YA HAY UN GANADOR, PULSA EN New Game PARA JUGAR DE NUEVO 👍", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(baseContext, "ESTA CASILLA YA ESTÁ OCUPADA, INTENTA JUGAR EN OTRA 🤓", Toast.LENGTH_LONG).show()
            }

        }

        //--------------------*--------------------*--------------------*--------------------

        //CASILLA 7
        binding.casilla7.setOnClickListener {
            // Verificar que esté vacía
            if(casillas[6] == "N" && !ganador){

                //Turno del jugador X
                if(jugadorActual){
                    binding.casilla7.text = "X"
                    casillas[6] = "X"
                    Log.i("ArrayCasillas", "${casillas.toString()}")
                    binding.currentPlayer.text = "Current Player: O"
                    jugadorActual = false;

                    if((casillas[0] == "X" && casillas[3] == "X" && casillas[6] == "X")){
                        Toast.makeText(baseContext, "EL JUGADOR X GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla1.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla4.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla7.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        ganador = true

                    }else if((casillas[6] == "X" && casillas[7] == "X" && casillas[8] == "X")){
                        Toast.makeText(baseContext, "EL JUGADOR X GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla7.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla8.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla9.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        ganador = true

                    }else if((casillas[2] == "X" && casillas[4] == "X" && casillas[6] == "X")){
                        Toast.makeText(baseContext, "EL JUGADOR X GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla3.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla5.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla7.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        ganador = true

                    }

                    // Turno del jugador O
                } else {
                    binding.casilla7.text = "O"
                    casillas[6] = "O"
                    Log.i("ArrayCasillas", "${casillas.toString()}")
                    binding.currentPlayer.text = "Current Player: X"
                    jugadorActual = true;

                    if((casillas[0] == "O" && casillas[3] == "O" && casillas[6] == "O")){
                        Toast.makeText(baseContext, "EL JUGADOR O GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla1.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        binding.casilla4.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        binding.casilla7.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        ganador = true

                    }else if((casillas[6] == "O" && casillas[7] == "O" && casillas[8] == "O")){
                        Toast.makeText(baseContext, "EL JUGADOR O GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla7.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        binding.casilla8.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        binding.casilla9.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        ganador = true

                    }else if((casillas[2] == "O" && casillas[4] == "O" && casillas[6] == "O")){
                        Toast.makeText(baseContext, "EL JUGADOR O GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla3.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla5.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla7.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        ganador = true

                    }
                }
            }else if(ganador){
                Toast.makeText(baseContext, "YA HAY UN GANADOR, PULSA EN New Game PARA JUGAR DE NUEVO 👍", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(baseContext, "ESTA CASILLA YA ESTÁ OCUPADA, INTENTA JUGAR EN OTRA 🤓", Toast.LENGTH_LONG).show()
            }

        }

        //--------------------*--------------------*--------------------*--------------------

        //CASILLA 8
        binding.casilla8.setOnClickListener {
            // Verificar que esté vacía
            if(casillas[7] == "N" && !ganador){

                //Turno del jugador X
                if(jugadorActual){
                    binding.casilla8.text = "X"
                    casillas[7] = "X"
                    Log.i("ArrayCasillas", "${casillas.toString()}")
                    binding.currentPlayer.text = "Current Player: O"
                    jugadorActual = false;

                    if((casillas[1] == "X" && casillas[4] == "X" && casillas[7] == "X")){
                        Toast.makeText(baseContext, "EL JUGADOR X GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla2.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla5.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla8.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        ganador = true

                    }else if((casillas[6] == "X" && casillas[7] == "X" && casillas[8] == "X")){
                        Toast.makeText(baseContext, "EL JUGADOR X GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla7.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla8.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla9.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        ganador = true
                    }

                    // Turno del jugador O
                } else {
                    binding.casilla8.text = "O"
                    casillas[7] = "O"
                    Log.i("ArrayCasillas", "${casillas.toString()}")
                    binding.currentPlayer.text = "Current Player: X"
                    jugadorActual = true;

                    if((casillas[1] == "O" && casillas[4] == "O" && casillas[7] == "O")){
                        Toast.makeText(baseContext, "EL JUGADOR O GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla2.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        binding.casilla5.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        binding.casilla8.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        ganador = true

                    }else if((casillas[6] == "O" && casillas[7] == "O" && casillas[8] == "O")){
                        Toast.makeText(baseContext, "EL JUGADOR O GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla7.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        binding.casilla8.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        binding.casilla9.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        ganador = true

                    }
                }
            }else if(ganador){
                Toast.makeText(baseContext, "YA HAY UN GANADOR, PULSA EN New Game PARA JUGAR DE NUEVO 👍", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(baseContext, "ESTA CASILLA YA ESTÁ OCUPADA, INTENTA JUGAR EN OTRA 🤓", Toast.LENGTH_LONG).show()
            }

        }

        //--------------------*--------------------*--------------------*--------------------

        //CASILLA 9
        binding.casilla9.setOnClickListener {
            // Verificar que esté vacía
            if(casillas[8] == "N" && !ganador){

                //Turno del jugador X
                if(jugadorActual){
                    binding.casilla9.text = "X"
                    casillas[8] = "X"
                    Log.i("ArrayCasillas", "${casillas.toString()}")
                    binding.currentPlayer.text = "Current Player: O"
                    jugadorActual = false;

                    if((casillas[0] == "X" && casillas[4] == "X" && casillas[8] == "X")){
                        Toast.makeText(baseContext, "EL JUGADOR X GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla1.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla5.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla9.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        ganador = true

                    }else if((casillas[6] == "X" && casillas[7] == "X" && casillas[8] == "X")){
                        Toast.makeText(baseContext, "EL JUGADOR X GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla7.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla8.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla9.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        ganador = true

                    }else if((casillas[2] == "X" && casillas[5] == "X" && casillas[8] == "X")){
                        Toast.makeText(baseContext, "EL JUGADOR X GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla3.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla6.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla9.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        ganador = true

                    }

                    // Turno del jugador O
                } else {
                    binding.casilla9.text = "O"
                    casillas[8] = "O"
                    Log.i("ArrayCasillas", "${casillas.toString()}")
                    binding.currentPlayer.text = "Current Player: X"
                    jugadorActual = true

                    if((casillas[0] == "O" && casillas[4] == "O" && casillas[8] == "O")){
                        Toast.makeText(baseContext, "EL JUGADOR O GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla1.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        binding.casilla5.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        binding.casilla9.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        ganador = true

                    }else if((casillas[6] == "O" && casillas[7] == "O" && casillas[8] == "O")){
                        Toast.makeText(baseContext, "EL JUGADOR O GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla7.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        binding.casilla8.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        binding.casilla9.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3F51B5"))
                        ganador = true

                    }else if((casillas[2] == "O" && casillas[5] == "O" && casillas[8] == "O")){
                        Toast.makeText(baseContext, "EL JUGADOR O GANÓ 🤩🎊!!", Toast.LENGTH_LONG).show()
                        binding.casilla3.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla6.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        binding.casilla9.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E91E63"))
                        ganador = true

                    }
                }
            }else if(ganador){
                Toast.makeText(baseContext, "YA HAY UN GANADOR, PULSA EN New Game PARA JUGAR DE NUEVO 👍", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(baseContext, "ESTA CASILLA YA ESTÁ OCUPADA, INTENTA JUGAR EN OTRA 🤓", Toast.LENGTH_LONG).show()
            }

        }

        binding.newGame.setOnClickListener {
            ganador = false
            casillas = arrayOf("N","N","N",
                                "N","N","N",
                                "N","N","N")
            binding.casilla1.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#409791"))
            binding.casilla2.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#409791"))
            binding.casilla3.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#409791"))
            binding.casilla4.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#409791"))
            binding.casilla5.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#409791"))
            binding.casilla6.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#409791"))
            binding.casilla7.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#409791"))
            binding.casilla8.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#409791"))
            binding.casilla9.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#409791"))

            binding.casilla1.text = " "
            binding.casilla2.text = " "
            binding.casilla3.text = " "
            binding.casilla4.text = " "
            binding.casilla5.text = " "
            binding.casilla6.text = " "
            binding.casilla7.text = " "
            binding.casilla8.text = " "
            binding.casilla9.text = " "

            jugadorActual = true
        }


    }
}