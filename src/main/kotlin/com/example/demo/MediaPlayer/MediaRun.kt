package com.example.demo.MediaPlayer

import tornadofx.launch

class MediaRun {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            launch<MediaApp>()
        }
    }
}