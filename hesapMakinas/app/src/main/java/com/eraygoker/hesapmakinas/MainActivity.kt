package com.eraygoker.hesapmakinas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eraygoker.hesapmakinas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    var number1:Double?=null
    var number2:Double?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        binding.buttonArti.setOnClickListener {
            number1 = binding.numberOne.text.toString().toDoubleOrNull()
            number2 = binding.numberTwo.text.toString().toDoubleOrNull()

            if (number1 != null && number2 != null) {
                binding.Sonuc.text = "Sonuc : ${number1!! + number2!!}"
            } else {
                binding.Sonuc.text = "shutup"
            }
        }

        binding.buttonEksi.setOnClickListener {
            number1 = binding.numberOne.text.toString().toDoubleOrNull()
            number2 = binding.numberTwo.text.toString().toDoubleOrNull()

            if (number1 != null && number2 != null) {
                binding.Sonuc.text = "Sonuc : ${number1!! - number2!!}"
            } else {
                binding.Sonuc.text = "Enter Number"
            }
        }

        binding.buttonCarpi.setOnClickListener {
            number1 = binding.numberOne.text.toString().toDoubleOrNull()
            number2 = binding.numberTwo.text.toString().toDoubleOrNull()

            if (number1 != null && number2 != null) {
                binding.Sonuc.text = "Sonuc : ${number1!! * number2!!}"
            } else {
                binding.Sonuc.text = "Enter Number"
            }

        }

        binding.buttonBolu.setOnClickListener {
            number1 = binding.numberOne.text.toString().toDoubleOrNull()
            number2 = binding.numberTwo.text.toString().toDoubleOrNull()

            if (number1 != null && number2 != null) {
                binding.Sonuc.text = "Sonuc : ${number1!! / number2!!}"
            } else {
                binding.Sonuc.text = "Enter Number"
            }


        }
    }
}