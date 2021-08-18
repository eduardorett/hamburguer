package com.devedu.hamburguer

import java.io.Serializable

//essa  data classe armazena os dados do cliente
// data class so recebe informação

data class Client(
    val name:String,
    val age:Int,
    val country:String
) : Serializable
