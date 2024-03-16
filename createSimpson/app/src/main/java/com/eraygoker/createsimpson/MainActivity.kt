package com.eraygoker.createsimpson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView



class MainActivity : AppCompatActivity() {

    private lateinit var textViewName:TextView
    private lateinit var textViewAge:TextView
    private lateinit var textViewJob:TextView
    private lateinit var textViewResult:TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textViewName=findViewById(R.id.name)
        textViewAge=findViewById(R.id.age)
        textViewJob=findViewById(R.id.job)
        textViewResult=findViewById(R.id.result)

    }


    fun buttonClick(view:View){
        var name=textViewName.text.toString()
        var age=textViewAge.text.toString().toIntOrNull()
        var job=textViewJob.text.toString()

        if (age==null)
            textViewResult.text="yasi giriniz"

        else {
            val simpson=Simpson(name,age,job)
            textViewResult.text = "ismi ${simpson.name} yasi ${simpson.age} ve isi ${simpson.job}"
        }



    }










}