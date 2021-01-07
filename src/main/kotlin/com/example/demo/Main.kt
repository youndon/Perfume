package com.example.demo

import net.objecthunter.exp4j.ExpressionBuilder

fun main(args: Array<String>) {

    val string = "1+2+3+4+5+6"
    val cal = ExpressionBuilder(string).build().evaluate()
    println(cal)

}