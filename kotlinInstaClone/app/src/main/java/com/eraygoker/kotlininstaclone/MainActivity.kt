package com.eraygoker.kotlininstaclone

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.eraygoker.kotlininstaclone.databinding.ActivityMainBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.core.View as View1


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        enableEdgeToEdge()
        setContentView(view)

        auth = Firebase.auth
        val currencyUser=auth.currentUser
        if (currencyUser!=null){
            val intent=Intent(this@MainActivity,FeedActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

        fun girisYapClick(view : View){

            val email=binding.email.text.toString()
            val password=binding.password.text.toString()

            if (email.equals("") || password.equals("")){
                Toast.makeText(this@MainActivity,"Enter Email and Password",Toast.LENGTH_LONG).show()
            }
            else{
                auth.signInWithEmailAndPassword(email,password).addOnSuccessListener {
                    val intent=Intent(this@MainActivity,FeedActivity::class.java)
                    startActivity(intent)
                    finish()
                }.addOnFailureListener {
                    Toast.makeText(this@MainActivity,it.localizedMessage,Toast.LENGTH_LONG).show()
                }

            }

        }

        fun kayitOlClick(view : View){

            val email=binding.email.text.toString()
            val password=binding.password.text.toString()

            if (email.equals("") || password.equals("")){
                Toast.makeText(this@MainActivity,"Enter Email and Password",Toast.LENGTH_LONG).show()
            }
            else {
                auth.createUserWithEmailAndPassword(email,password).addOnSuccessListener {
                    val intent=Intent(this@MainActivity,FeedActivity::class.java)
                    startActivity(intent)
                    finish()
                }.addOnFailureListener {
                    Toast.makeText(this@MainActivity,it.localizedMessage,Toast.LENGTH_LONG).show()
                }

            }
        }

}
