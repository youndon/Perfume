package com.example.demo

import net.objecthunter.exp4j.ExpressionBuilder

fun main(args: Array<String>) {

    val ss = ExpressionBuilder("e5").build().evaluate()
    println(ss)
}