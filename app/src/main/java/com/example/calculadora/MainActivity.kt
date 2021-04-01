package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()
        zero.setOnClickListener{ NewExpression(string = "0", limpar_dados = true) }
        one.setOnClickListener{ NewExpression(string = "1", limpar_dados = true) }
        two.setOnClickListener{ NewExpression(string = "2", limpar_dados = true) }
        three.setOnClickListener{ NewExpression(string = "3", limpar_dados = true) }
        four.setOnClickListener{ NewExpression(string = "4", limpar_dados = true) }
        five.setOnClickListener{ NewExpression(string = "5", limpar_dados = true) }
        six.setOnClickListener{ NewExpression(string = "6", limpar_dados = true) }
        seven.setOnClickListener{ NewExpression(string = "7", limpar_dados = true) }
        eight.setOnClickListener{ NewExpression(string = "8", limpar_dados = true) }
        nine.setOnClickListener{ NewExpression(string = "9", limpar_dados = true) }
        point.setOnClickListener { NewExpression(string = ".", limpar_dados = true) }

        //operators
        sum.setOnClickListener{NewExpression(string = " + ", limpar_dados = false)}
        subtration.setOnClickListener{NewExpression(string = " - ", limpar_dados = false)}
        multiply.setOnClickListener{NewExpression(string = " * ", limpar_dados = false)}
        division.setOnClickListener{NewExpression(string = " / ", limpar_dados = false)}

        clean.setOnClickListener {
            expression.text = ""
            resultado.text = ""
        }

        backspace.setOnClickListener {
            val string = expression.text.toString()

            if(string.isNotBlank()){
                expression.text = string.substring(0, string.length-1)
            }
            resultado.text = ""
        }

        equals.setOnClickListener {
            try {
                val expression = ExpressionBuilder(expression.text.toString()).build()

                val result = expression.evaluate()

                val longResult = result.toLong()

                if(result == longResult.toDouble()) {
                    resultado.text = longResult.toString()
                } else
                    resultado.text = result.toString()

            } catch (e: Exception) {

            }
        }


    }


    fun NewExpression(string: String, limpar_dados: Boolean){
        if (resultado.text.isNotEmpty()) {
            expression.text = ""
        }

        if (limpar_dados) {
            resultado.text = ""
            expression.append(string)
        } else {
            expression.append(resultado.text)
            expression.append(string)
            resultado.text = ""
        }
    }
}