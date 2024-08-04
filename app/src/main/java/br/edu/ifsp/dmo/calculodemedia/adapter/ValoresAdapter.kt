package br.edu.ifsp.dmo.calculodemedia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.ifsp.dmo.calculodemedia.R

class ValoresAdapter(private val valores: List<Double>) :
    RecyclerView.Adapter<ValoresAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val valorTextView: TextView = view.findViewById(R.id.valorTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_valor, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.valorTextView.text = valores[position].toString()
    }

    override fun getItemCount() = valores.size
}