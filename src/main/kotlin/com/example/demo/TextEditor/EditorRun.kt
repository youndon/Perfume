package com.example.demo.TextEditor

import tornadofx.launch

class EditorRun {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            launch<EditorApp>()
        }
    }
}