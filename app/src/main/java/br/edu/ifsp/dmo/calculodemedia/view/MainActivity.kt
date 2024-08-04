package br.edu.ifsp.dmo.calculodemedia.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.dmo.calculodemedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnValores.setOnClickListener {
            val intent = Intent(this, ValoresActivity::class.java)
            startActivity(intent)
        }

        binding.btnAjuda.setOnClickListener {
            val intent = Intent(this, AjudaActivity::class.java)
            startActivity(intent)
        }
    }
}
