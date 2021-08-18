package com.devedu.hamburguer

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.second_activity.*
import kotlinx.android.synthetic.main.toastshow.*
import android.app.Person as Person

class SecondActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        val name = intent.getStringExtra("EXTRA_NAME")
        val age = intent.getIntExtra("EXTRA_AGE", 0)
        val country = intent.getStringExtra("EXTRA_COUNTRY")
        val personString =
            " Hello $name, $age years old that lives in $country, please make your burguer"

        orderburguer.text = personString


        btnback.setOnClickListener {
            finish()
        }


        btnnext.setOnClickListener {  // ESSE BTN FAZ IR PARA A PROXIMA PAGINA ''start new activity''
            Intent(this, ThirdActivity::class.java).also {
                startActivity(it)  //criar o intent com this, chama a atividade::javaETC. ai also, e da start com context IT
                //NÃO VAI FUNCIONAR SE NÃO TIVER CRIADO A NOVA ACT NO MANIFEST
            }

        }

        btnorder.setOnClickListener {

            Toast(this).apply {
                duration = Toast.LENGTH_LONG //primeiro a duração
                view = layoutInflater.inflate(R.layout.toastshow, supertoast) //TOAST PERSONALIZADO
                show() //show em baixo diferente do .show() do toast normal
            }


            photo.setImageResource(R.drawable.burg) // é assim que da set em uma imagem

            val checkMeatid = meattype.checkedRadioButtonId // ve qual radio está clicado
            val meat =
                findViewById<RadioButton>(checkMeatid) // captura o id do que está clicado para usar depois
            val cheeseon = cheese.isChecked // is checked confere se está checado ou não,
            val onionon = onions.isChecked
            val saladon = salad.isChecked
            val orderString =
                "You just ordered a burguer with\n" + // o + é para pular linha alem do \n
                        "${meat.text}" +
                        (if (cheeseon) "\ncheese" else "") +
                        (if (onionon) "\nonion" else "") +
                        (if (saladon) "\nsalad" else "")

            viewburguer.text = orderString

            Toast.makeText(this, "THANKS FOR ORDERING WITH EDUBURGUERS", Toast.LENGTH_LONG).show()


        }
    }
}

