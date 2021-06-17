package com.example.imc_app.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import java.lang.Math.round
import kotlin.math.pow
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.roundToInt


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
        if(imcValue <= 28.30) {
            msg = "$imcValue acima do peso"
        }
       return msg
   }
}