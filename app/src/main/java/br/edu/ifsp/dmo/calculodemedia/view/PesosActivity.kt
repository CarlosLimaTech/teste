package br.edu.ifsp.dmo.calculodemedia.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.ifsp.dmo.calculodemedia.adapter.PesosAdapter
import br.edu.ifsp.dmo.calculodemedia.databinding.ActivityPesosBinding

class PesosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPesosBinding
    private val pesos = mutableListOf<Double>()
    private lateinit var adapter: PesosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPesosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = PesosAdapter(pesos)
        binding.recyclerViewPesos.adapter = adapter
        binding.recyclerViewPesos.layoutManager = LinearLayoutManager(this)

        val valores = intent.getDoubleArrayExtra("valores")?.toList() ?: listOf()
        val tipoMedia = intent.getStringExtra("tipoMedia") ?: "Média Aritmética"

        binding.btnAdicionarPeso.setOnClickListener {
            val peso = binding.editTextPeso.text.toString().toDoubleOrNull()
            if (peso != null) {
                pesos.add(peso)
                adapter.notifyDataSetChanged()
                binding.editTextPeso.text.clear()
            } else {
                // Adicionar feedback para o usuário se o peso for inválido
            }
        }

        binding.btnCalcularMedia.setOnClickListener {
            if (pesos.size == valores.size) {
                val intent = Intent(this, CalculoMediaActivity::class.java)
                intent.putExtra("valores", valores.toDoubleArray())
                intent.putExtra("pesos", pesos.toDoubleArray())
                intent.putExtra("tipoMedia", tipoMedia)
                startActivity(intent)
            } else {
                // Exibir mensagem para o usuário informando que o número de pesos deve corresponder ao número de valores
            }
        }

        binding.btnVoltar.setOnClickListener {
            finish()
        }
    }
}
