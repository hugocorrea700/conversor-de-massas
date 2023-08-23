package com.github.hugocorrea700.cedtec

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.hugocorrea700.cedtec.databinding.ActivityMainBinding
import java.lang.Math.ceil
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener{ calculateTip()}
    }
    fun calculateTip() {

        val stringInTextField = binding.costOfService.text.toString()
        val massa = stringInTextField.toDouble()
        val selectedId = binding.tipOptions.checkedRadioButtonId
        val multiplicadorManeira = when (selectedId) {
            R.id.kg_to_lbs -> 2.2
            else -> 0.45
        }
        var massaNova = multiplicadorManeira * massa

        NumberFormat.getCurrencyInstance()
        val massaConvertida = NumberFormat.getCurrencyInstance().format(massaNova)
        binding.tipResult.text = getString(R.string.resultado_massa, massaConvertida)

    }
}
