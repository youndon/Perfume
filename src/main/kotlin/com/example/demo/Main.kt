package com.example.demo

import net.objecthunter.exp4j.ExpressionBuilder

fun main(args: Array<String>) {

    val go = ExpressionBuilder("π").build().evaluate()
    println(go)

}