package com.example.demo.BinaryClock

import tornadofx.launch

class BinaryRun {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            launch<BinaryApp>()
        }
    }
}