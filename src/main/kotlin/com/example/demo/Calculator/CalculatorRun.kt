package com.example.demo.Calculator

import tornadofx.launch

class CalculatorRun {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            launch<CalculatorApp>()
        }
    }
}