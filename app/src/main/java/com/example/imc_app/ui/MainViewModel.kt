package com.example.imc_app.ui

import androidx.lifecycle.ViewModel
import java.math.BigDecimal
import java.math.RoundingMode


class MainViewModel : ViewModel() {
    fun calculateIMC(weight: String, height: String) : Double {
        var weight = weight.toFloatOrNull()
        var height = height.toFloatOrNull()
        var imc = 0.00
        println("Weight: $weight")
        println("Height: $height")

        if (weight != null && height != null) {
            imc = (weight / (height * height)).toDouble()
            imc = BigDecimal(imc).setScale(2, RoundingMode.HALF_EVEN).toDouble()
        }

        println("Imc: $imc")

        return imc
    }

   fun checkIMC(imcValue: Double) : String {
       var msg = ""
        if(imcValue < 18.50) {
            msg = "$imcValue Abaixo do peso"
        } else if(imcValue > 18.50 && imcValue <= 24.90){
            msg = "$imcValue Peso normal"
        } else if(imcValue > 25 && imcValue <= 29.90) {
            msg = "$imcValue Acima do peso"
        } else if(imcValue > 30.90 && imcValue <= 34.90) {
            msg = "$imcValue Obesidade Grau I"
        } else if(imcValue > 35.0 && imcValue <= 40.0) {
            msg = "$imcValue Obesidade Grau II"
        } else if(imcValue >= 40.0) {
            msg = "$imcValue Obesidade Grau III"
        }
       return msg
   }
}