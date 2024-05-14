package com.eraygoker.kotlininstaclone

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.IntentCompat
import androidx.core.content.PackageManagerCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.eraygoker.kotlininstaclone.databinding.ActivityUploadBinding
import com.google.android.material.snackbar.Snackbar

class UploadActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUploadBinding
    private lateinit var activityResultLauncher:ActivityResultLauncher<Intent>
    private lateinit var permissionLauncher: ActivityResultLauncher<String>
    var selectedPicture:Uri?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityUploadBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        registerLauncher()
    }
        fun uploadClick(view: View){



        }

        fun selectImage(view: View){

            if (ContextCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    Snackbar.make(view,"permissinon needed for gallery",Snackbar.LENGTH_LONG).setAction("Give Permission"){}.show()
                    permissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)

                }
                else{
                    permissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
                }

            }
            else{
                val intentToGallery=Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                activityResultLauncher.launch(intentToGallery)

            }

        }

        private fun registerLauncher(){
            activityResultLauncher=registerForActivityResult(ActivityResultContracts.StartActivityForResult(),){result->
                if (result.resultCode== RESULT_OK){
                    val IntentFromResult=result.data
                    if (IntentFromResult!=null){
                        selectedPicture=IntentFromResult.data
                        selectedPicture?.let {
                            binding.imageView.setImageURI(it)
                        }
                    }
                }
            }
            permissionLauncher=registerForActivityResult(ActivityResultContracts.RequestPermission(),){result->
                if (result){
                    val intentToGallery=Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                    activityResultLauncher.launch(intentToGallery)
                }
                else{
                    Toast.makeText(this@UploadActivity,"Permission needed",Toast.LENGTH_LONG).show()
                }
            }
        }

}
