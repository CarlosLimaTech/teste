package br.edu.ifsp.dmo.calculodemedia.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.dmo.calculodemedia.databinding.ActivityAjudaBinding

class AjudaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAjudaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAjudaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Botões para abrir vídeos no YouTube
        binding.btnVideoAritmetica.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/QS6sdNaIEo8"))
            startActivity(intent)
        }

        binding.btnVideoPonderada.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/xkHf8L0eTgU"))
            startActivity(intent)
        }

        binding.btnVideoHarmonica.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/17AW2znpYmU"))
            startActivity(intent)
        }

        // Botões para abrir textos complementares
        binding.btnTextoAritmetica.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.somatematica.com.br/fundam/medidas/medidas.php"))
            startActivity(intent)
        }

        binding.btnTextoPonderada.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.somatematica.com.br/emedio/estat/medidas3.php"))
            startActivity(intent)
        }

        binding.btnTextoHarmonica.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.somatematica.com.br/emedio/estat/medidas4.php"))
            startActivity(intent)
        }

        binding.btnVoltar.setOnClickListener {
            finish()
        }
    }
}
