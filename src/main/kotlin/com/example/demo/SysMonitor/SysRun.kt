package com.example.demo.SysMonitor

import tornadofx.launch

class SysRun {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            launch<SysApp>()
        }
    }
}