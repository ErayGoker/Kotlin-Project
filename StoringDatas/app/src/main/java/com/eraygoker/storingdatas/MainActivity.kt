package com.eraygoker.storingdatas

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eraygoker.storingdatas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var agePref:Int?=null
    var age:Int?=null
    private lateinit var sharedPref:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPref=this.getSharedPreferences("com.eraygoker.storingdata", MODE_PRIVATE)
        age=binding.ageText.text.toString().toIntOrNull()
        agePref=sharedPref.getInt("age",-1)

        if(agePref!=-1)
            binding.textView.text="Age is ${agePref!!}"
        else
            binding.textView.text="Enter Age"




        binding.save.setOnClickListener(){
            age=binding.ageText.text.toString().toIntOrNull()
            if (age!=null) {
                binding.textView.text = "Age is ${age!!}"
                sharedPref.edit().putInt("age",age!!).apply()
            }
        }

        binding.delete.setOnClickListener(){
            agePref=sharedPref.getInt("age",-1)
            if(agePref!=null) {
                sharedPref.edit().remove("age").apply()

            }
            binding.textView.text=" Enter age"

        }

    }
}