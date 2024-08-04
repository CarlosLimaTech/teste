package br.edu.ifsp.dmo.calculodemedia.view

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.ifsp.dmo.calculodemedia.R
import br.edu.ifsp.dmo.calculodemedia.adapter.ValoresAdapter
import br.edu.ifsp.dmo.calculodemedia.databinding.ActivityValoresBinding

class ValoresActivity : AppCompatActivity() {

    private lateinit var binding: ActivityValoresBinding
    private val valores = mutableListOf<Double>()
    private lateinit var adapter: ValoresAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityValoresBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ValoresAdapter(valores)
        binding.recyclerViewValores.adapter = adapter
        binding.recyclerViewValores.layoutManager = LinearLayoutManager(this)

        val tiposMediaAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.tipos_media,
            android.R.layout.simple_spinner_item
        )
        tiposMediaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerTipoMedia.adapter = tiposMediaAdapter

        binding.btnAdicionarValor.setOnClickListener {
            val valor = binding.editTextValor.text.toString().toDoubleOrNull()
            if (valor != null) {
                valores.add(valor)
                adapter.notifyDataSetChanged()
                binding.editTextValor.text.clear()
            } else {
                // Adicionar feedback para o usuário se o valor for inválido
            }
        }

        binding.btnProximo.setOnClickListener {
            if (valores.isNotEmpty()) {
                val intent = Intent(this, PesosActivity::class.java)
                intent.putExtra("valores", valores.toDoubleArray())
                intent.putExtra("tipoMedia", binding.spinnerTipoMedia.selectedItem.toString())
                startActivity(intent)
            } else {
                // Exibir mensagem para o usuário informando que deve adicionar valores
            }
        }

        binding.btnVoltar.setOnClickListener {
            finish()
        }
    }
}
