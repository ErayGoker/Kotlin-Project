package com.eraygoker.kotlinlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.eraygoker.kotlinlearning.R.id.textView

    lateinit var myTextView: TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myTextView=findViewById(R.id.textView)

        mySum(14,34)




    }

    fun mySum(a:Int,b:Int){

        myTextView.text="Result ${a*b}"

    }

    fun buttonClick(view: View){

        myTextView.text="butona tiklandi"
    }

}