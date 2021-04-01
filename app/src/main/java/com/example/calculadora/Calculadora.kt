package com.example.calculadora

fun main(args: Array<String>){
    val x = 11
    val y = 2

    val resultado = soma(x, y)
    println("O resultado da soma é = $resultado")

}
//Metodo soma
fun soma(x: Int, y: Int) = x + y

//Metodo multiplicar
fun multiplicar(x: Int, y: Int) = x * y

//Metodo dividir
fun dividir(x: Int, y: Int) = x / y

//Metodo subtrair
fun subtrair(x: Int, y: Int) = x - y