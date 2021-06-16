package com.example.imc_app.ui

import androidx.lifecycle.ViewModel
import java.math.BigDecimal
import java.math.RoundingMode


class MainViewModel : ViewModel() {
    fun calculateIMC(weight: String, height: String) : BigDecimal? {
        var weight = weight.toFloatOrNull()
        var height = height.toFloatOrNull()
        var imc = BigDecimal.ZERO

        if (weight != null && height != null) {
            imc = (weight / (height * height)).toBigDecimal().setScale(2, RoundingMode.UP)
        }

        return imc
    }
}