package com.devedu.hamburguer


import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log


import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_third.*


class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

// AS VALS ABAIXO SÃO PARA PRINTAR O TEXT RECEBENDO DA SECEONDACTIVITY
        //intent é oque possibilita o recebimento da outra activity
//
//        val name = intent.getStringExtra("EXTRA_NAME")
//        val age = intent.getIntExtra("EXTRA_AGE",0)
//        val country = intent.getStringExtra("EXTRA_COUNTRY")
//         val personString = "$name is $age years old and lives in $country"

//        val person = intent.getSerializableExtra("EXTRA_PERSON") as Client // metodo alternaivo de receber dados e printar usando classe e as xxxx
//        textRecive.text = person.toString()

//        val getImage = registerForActivityResult(
//            ActivityResultContracts.GetContent(),
//            ActivityResultCallback {
//
//            binding.imageView.setImageURI(it)
//
//            }
//        )


        btnbackB.setOnClickListener {
            finish()
        }

        btnsearchphoto.setOnClickListener {
            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type = "image/*"
              startActivityForResult(it, 0)
            }
        }

        // essa activity recebe permisões, que tem que ser habilitadas no manifest com uses-permision
        btnrequestPermission.setOnClickListener {
            resquestPermission()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK && requestCode == 0){
            val uri = data?.data
            ivphoto.setImageURI(uri)
        }
    }

        fun externalStoragePermision() =
            ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED

        fun coarseLocationPermision() =
            ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED


        fun backgroundLocationPermision() =
            ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_BACKGROUND_LOCATION) == PackageManager.PERMISSION_GRANTED

        private fun resquestPermission(){
            val permissionToRequest= mutableListOf<String>()

            if(!externalStoragePermision()){
                permissionToRequest.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            }
            if(!coarseLocationPermision()){
                permissionToRequest.add(Manifest.permission.ACCESS_COARSE_LOCATION)
            }
            if(!backgroundLocationPermision()){
                permissionToRequest.add(Manifest.permission.ACCESS_COARSE_LOCATION)
            }
            if(permissionToRequest.isNotEmpty()){
               ActivityCompat.requestPermissions(this,permissionToRequest.toTypedArray(),0)
            }
        }

        override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<out String>,
            grantResults: IntArray
        ) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults)
            if(requestCode==0 && grantResults.isNotEmpty()){
                for (i in grantResults.indices){
                    if (grantResults[i]== PackageManager.PERMISSION_GRANTED){
                        Log.d("PermissionResquest","${permissions[i]} granted")
                    }
                }
            }
        }

    }
