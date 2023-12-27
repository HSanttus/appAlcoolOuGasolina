package com.example.ecoflexchoice_drive

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var textInputAlcool: TextInputLayout
    private lateinit var editAlcool: TextInputEditText

    private lateinit var textInputGasolina: TextInputLayout
    private lateinit var editGasolina: TextInputEditText

    private lateinit var btnCalcular: Button
    private lateinit var textResulado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inializarComponentesInteface()
        btnCalcular.setOnClickListener {
            calcularMelhorPreco()
        }
    }

    private fun calcularMelhorPreco() {
        val precoAlcool = editAlcool.text.toString()
        val precoGasolina = editGasolina.text.toString()
//O toString pega os valores da caixa de texto e transforma em string(por padrão)
        val resultadoValidacao = validarCampos(precoAlcool, precoGasolina)
        if (resultadoValidacao){
            /*Cálculo de melhor preço
             *se(valorAlccol / valorGasolinda) >= 0.7 é melhor utilizar gasolina
             *senão é melhor utilizar álcool.
             * */
            val precoAlcooNumero = precoAlcool.toDouble()
            val precoGasolinaNumero = precoGasolina.toDouble()
            //o toDouble converte a string para número e só assim poder calcular
            val resultado = (precoAlcooNumero / precoGasolinaNumero)

            if (resultado >= 0.7){
                textResulado.text = "Melhor Utilizar a Gasolina"
            }else {
                textResulado.text = "Melhor Utilizar o Álcool"
            }
        }
    }

    private fun validarCampos(pAlcool: String, pGasolina: String): Boolean {
        textInputAlcool.error = null
        textInputGasolina.error = null

        if (pAlcool.isEmpty()) {
            textInputAlcool.error = "Digite o preço do álcool"
            return false
        }else if(pGasolina.isEmpty()){
            textInputGasolina.error = "Digite o preço da gasolina"
            return false
        }else{
            return true
        }


    }

    private fun inializarComponentesInteface() {
    textInputAlcool = findViewById(R.id.text_input_alcool)
    editAlcool = findViewById(R.id.edit_alcool)

    textInputGasolina = findViewById(R.id.text_input_gasolina)
    editGasolina = findViewById(R.id.edit_gasolina)

    btnCalcular = findViewById(R.id.btn_calcular)
    textResulado = findViewById(R.id.text_resultado)
}
}