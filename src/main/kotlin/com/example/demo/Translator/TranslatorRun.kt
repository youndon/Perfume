package com.example.demo.Translator

import tornadofx.launch

class TranslatorRun {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            launch<TranslatorApp>()
        }
    }
}