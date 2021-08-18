package com.devedu.hamburguer

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toastshow.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        btnApplyB.setOnClickListener {

// Esse botão envia informações para o activity_third
// aprendemos a chamar os edits transformando eles em vals
// aprendemos a registrar eles para envio com o it.putExtra

            val name = editName.text.toString() //tem que criar uma val para cada um dos edit text para capturarmos e usarmos aqui
            val age = editAge.text.toString().toInt()
            val country = editCountry.text.toString()

            //val person = Client(name,age,country) // RECEBE A CLASS PERSON QUE VAI ARMAZENAR TUDO ISSO
            Intent(this,SecondActivity::class.java).also {
               // it.putExtra("EXTRA_PERSON",person) //assim que simplifica, val pra receber data class e ai putextra na val que recebe a classe
// é assim que se faz sem a val person com a class

               it.putExtra("EXTRA_NAME",name)
               it.putExtra("EXTRA_AGE",age)
                it.putExtra("EXTRA_COUNTRY",country)

                startActivity(it)

            }
        }



        btnnextB.setOnClickListener {
            Intent(this,SecondActivity::class.java).also{
                startActivity(it)
            }
        }


    }
    }
