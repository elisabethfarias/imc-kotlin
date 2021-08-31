package com.example.imc_app.model

import com.example.imc_app.viewmodel.MainViewModel
import junit.framework.TestCase
import org.junit.Test


class CalculoImcTest : TestCase() {
    private var mainViewModel :  MainViewModel = MainViewModel()

    @Test
    fun `test imc calculation` () {
        val result = mainViewModel.calculateIMC("68.0",  "1.57")
        assertEquals(27.59, result)

    }

    @Test
    fun `test message` () {
        val resultImc = mainViewModel.calculateIMC("68.0",  "1.57")
        val imcMessage = mainViewModel.checkIMC(resultImc)
        assertEquals("27.59 Acima do peso", imcMessage)
    }

}

//fun calculateIMC(weight: String, height: String) : Double {
//    var weight = weight.toFloatOrNull()
//    var height = height.toFloatOrNull()
//    var imc = 0.00
//    println("Weight: $weight")
//    println("Height: $height")
//
//    if (weight != null && height != null) {
//        imc = (weight / (height * height)).toDouble()
//        imc = BigDecimal(imc).setScale(2, RoundingMode.HALF_EVEN).toDouble()
//    }
//
//    println("Imc: $imc")
//
//    return imc
//}