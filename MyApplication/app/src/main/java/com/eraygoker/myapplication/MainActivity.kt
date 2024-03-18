package com.eraygoker.myapplication

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this@MainActivity,"welcome",Toast.LENGTH_LONG).show()


    }

    fun ekle(view: View){
            val alert=AlertDialog.Builder(this@MainActivity)
            alert.setTitle("kayit")
            alert.setMessage("kayit olamk istediginize emin misin ")
            alert.setPositiveButton("yes",object :DialogInterface.OnClickListener{
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    Toast.makeText(this@MainActivity,"kaydolundu",Toast.LENGTH_SHORT).show()
                }
            })
            alert.setNegativeButton("no",object :DialogInterface.OnClickListener{
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    Toast.makeText(this@MainActivity,"kaydedilmedi",Toast.LENGTH_SHORT).show()
                }

            })

            alert.show()

    }

}