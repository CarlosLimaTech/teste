package br.edu.ifsp.dmo.calculodemedia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.ifsp.dmo.calculodemedia.R

class PesosAdapter(private val pesos: List<Double>) :
    RecyclerView.Adapter<PesosAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val pesoTextView: TextView = view.findViewById(R.id.pesoTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_peso, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.pesoTextView.text = pesos[position].toString()
    }

    override fun getItemCount() = pesos.size
}