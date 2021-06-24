package com.example.imc_app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.imc_app.R
import com.example.imc_app.databinding.ActivityMainBinding
import com.example.imc_app.viewmodel.MainViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding //lembra de anota esse trecho
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        observe()
        setListeners()
    }

    private fun observe() {
        mainViewModel.presentation.observe(this, {
            binding.presentation = it
        })
        mainViewModel.initPresentation()
    }

    private fun setListeners() {
        val inputWeight = binding.formWeight.editText
        val inputHeight = binding.formHeigth.editText

        val calculate = binding.btnCalculate

        inputWeight?.doAfterTextChanged { value ->
            mainViewModel.validate(value.toString())
        }

        inputHeight?.doAfterTextChanged { value ->
           mainViewModel.validate(value.toString())
        }

        calculate.setOnClickListener {
            if (inputWeight?.text.toString().isNullOrEmpty() && inputHeight?.text.toString().isNullOrEmpty() ) {
                inputWeight?.error = "Preencha o campo"
                inputHeight?.error = "Preencha o campo"
                binding.tvTitle.text = "Cálculo de IMC"
            }

            val imcValue = mainViewModel.calculateIMC(inputWeight?.text.toString(), inputHeight?.text.toString())
            val imcResultMessage = mainViewModel.checkIMC(imcValue)

            if (imcValue > 0 && imcValue != 0.0) {
                println("ImcValue: $imcValue")
                binding.tvTitle.text = imcResultMessage
            }
        }
    }


}

