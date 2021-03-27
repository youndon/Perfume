package com.example.demo.Browser

import tornadofx.launch

class BrowserRun {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            launch<BrowserApp>()
        }
    }
}