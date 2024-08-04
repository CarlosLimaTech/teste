package br.edu.ifsp.dmo.calculodemedia.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.dmo.calculodemedia.databinding.ActivityCalculoMediaBinding
import br.edu.ifsp.dmo.calculodemedia.model.*
import java.text.DecimalFormat

class CalculoMediaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCalculoMediaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculoMediaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val valores = intent.getDoubleArrayExtra("valores")?.toList()
        val pesos = intent.getDoubleArrayExtra("pesos")?.toList()
        val tipoMedia = intent.getStringExtra("tipoMedia") ?: "Média Aritmética"

        if (valores != null && valores.isNotEmpty()) {
            val strategy: MediaStrategy = when (tipoMedia) {
                "Média Ponderada" -> MediaPonderada()
                "Média Harmônica" -> MediaHarmonica()
                else -> MediaAritmetica()
            }

            val resultado = strategy.calcular(valores, pesos)
            val decimalFormat = DecimalFormat("#.#")
            binding.textViewResultado.text = decimalFormat.format(resultado)
        } else {
            binding.textViewResultado.text = "Erro: Valores ou Pesos inválidos"
        }

        binding.btnCalcularNovaMedia.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.btnVoltar.setOnClickListener {
            finish()
        }
    }
}
