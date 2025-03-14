package com.example.taller1Movil.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.taller1Movil.databinding.PilotRowBinding
import com.example.tuapp.models.Driver

// Opté por utilizar un base adapter para poder manejar mas explicitamente la lógica de la vista
// Además según lo que pude investigar baseadapter funciona mejor para archivos tipo json debido a que tienen varios campos
class DriverAdapter(private val context: Context?, private val drivers: List<Driver>) : BaseAdapter() {

    // Estos son los 4 metodos esenciales para sobreescribir de un baseadapter
    override fun getCount(): Int = drivers.size
    override fun getItem(position: Int): Driver = drivers[position]
    override fun getItemId(position: Int): Long = drivers[position].driverNumber.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: PilotRowBinding

        val view: View = if (convertView == null) { // Esto es para mejorar el rendimiento, revisa si la vista esta inflada o no
            binding = PilotRowBinding.inflate(LayoutInflater.from(context), parent, false)
            binding.root.tag = binding // Guardamos la vista para reutilizarla y no tener que
            binding.root
        } else {
            binding = convertView.tag as PilotRowBinding
            convertView
        }

        val driver = getItem(position)

        binding.numeroPiloto.text = driver.driverNumber.toString()
        binding.nombrePiloto.text = driver.fullName

        return view
    }
}
