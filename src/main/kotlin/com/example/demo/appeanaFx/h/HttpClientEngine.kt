package com.example.demo.appeanaFx.h

import tornadofx.HttpClientEngine

class HttpClientEngine {
    lateinit var httpClientEngine: HttpClientEngine
    init {
        httpClientEngine.run {
//            this.client // todo
//            this.context // todo
            this.rest
        }
    }
}