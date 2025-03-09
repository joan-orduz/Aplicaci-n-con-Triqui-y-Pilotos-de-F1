package com.example.taller1Movil.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.taller1Movil.databinding.PilotRowBinding
import com.example.tuapp.models.Driver

class DriverAdapter(private val context: Context?, private val drivers: List<Driver>) : BaseAdapter() {

    override fun getCount(): Int = drivers.size

    override fun getItem(position: Int): Driver = drivers[position]

    override fun getItemId(position: Int): Long = drivers[position].driverNumber.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: PilotRowBinding

        val view: View = if (convertView == null) {
            binding = PilotRowBinding.inflate(LayoutInflater.from(context), parent, false)
            binding.root.tag = binding // Guardamos la vista para reutilizarla
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
