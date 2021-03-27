package com.example.demo.BinaryConvert

import net.objecthunter.exp4j.ExpressionBuilder
import kotlin.math.absoluteValue
import kotlin.math.pow

@Suppress("LABEL_NAME_CLASH")
sealed class Converter {
    data class Text(private val txt: List<String>) {
        fun bin(): String {
            val ss = StringBuffer()
            txt.forEach { line ->
                val cc = arrayListOf<String>()
                line.forEach {
                    cc.add(Integer.toBinaryString(it.toInt()))
                }
                ss.appendln(cc.toList().joinToString(" "))
            }
            return ss.toString()
        }

        fun hex(): String {
            val ss = StringBuffer()
            txt.forEach { line ->
                val cc = arrayListOf<String>()
                line.forEach {
                    cc.add(Integer.toHexString(it.toInt()).toUpperCase())
                }
                ss.appendln(cc.toList().joinToString(" "))
            }
            return ss.toString()
        }

        fun octal(): String {
            val ss = StringBuffer()
            txt.forEach { line ->
                val cc = arrayListOf<String>()
                line.forEach {
                    cc.add(Integer.toOctalString(it.toInt()))
                }
                ss.appendln(cc.toList().joinToString(" "))
            }
            return ss.toString()
        }

        fun integer(): String {
            val ss = StringBuffer()
            txt.forEach { line ->
                val cc = arrayListOf<String>()
                line.forEach {
                    cc.add("${it.toInt()}")
                }
                ss.appendln(cc.toList().joinToString(" "))
            }
            return ss.toString()
        }
    }

    data class Bin(private val bin: List<String>) {
        fun txt(): String {
            val ss = StringBuffer()
            bin.forEach { line ->
                val cc = arrayListOf<String>()
                line.split(" ").forEach {
                    cc.add("${Integer.parseInt(it, 2).toChar()}")
                }
                ss.appendln(cc.toList().joinToString(""))
            }
            return ss.toString()
        }
        fun integer(): String {
            val ss = StringBuffer()
            bin.forEach { line ->
                val cc = arrayListOf<String>()
                line.split(" ").forEach {
                        cc.add("${Integer.parseInt(it, 2)}")
                }
                ss.appendln(cc.toList().joinToString(" "))
            }
            return ss.toString()
        }
        @Deprecated("this secondary option!")
        private fun sDecimal(): String {
            val ss = StringBuffer()
            bin.forEach { lines ->
                val cc = arrayListOf<String>()
                lines.split(" ").forEach { line ->
                    val las0 = ExpressionBuilder(line).build().evaluate().toBigDecimal()
                        .toString().takeLast(line.toBigDecimal().scale()).toList()
                    val integerpart =
                        CodingList().decreasing().zip(las0).filter { it.second == '1' }.sumByDouble { it.first }
                    val decimalpart = Integer.parseInt(line.substringBefore('.'), 2)
                    cc.add("${integerpart + decimalpart}")
                }
                ss.appendln(cc.toList().joinToString(" "))
            }
            return ss.toString()
        }
        @ExperimentalStdlibApi
        fun decimal(): String {
            val ss = StringBuffer()
            val fraction = arrayListOf<Double>()
            val integer = arrayListOf<Double>()
            bin.forEach { line ->
                line.split(" ").forEach {
                    if (!it.contains('.')) return "Some binary not correct!"
                    it.split(".").last().reversed().forEachIndexed { index, c ->
                        fraction.add(ExpressionBuilder("$c").build().evaluate() * 2.0.pow(-(index + 1)))
                    }
                    it.split(".").first().reversed().forEachIndexed { index, c ->
                        integer.add(ExpressionBuilder("$c").build().evaluate() * 2.0.pow(index))
                    }
                }
                ss.appendln("${integer.sum()+fraction.sumByDouble { d -> d }}")
            }
            return ss.toString()
        }
        fun hex(): String {
            return Text(txt().lines()).hex()
        }
        fun octal(): String {
            return Text(txt().lines()).octal()
        }
    }

    data class Hex(private val hex: List<String>) {
        fun txt(): String {
            val ss = StringBuffer()
            hex.forEach { line ->
                val cc = arrayListOf<String>()
                line.split(" ").forEach {
                    cc.add("${Integer.parseInt(it, 16).toChar()}")
                }
                ss.appendln(cc.toList().joinToString(""))
            }
            return ss.toString()
        }

        fun bin(): String {
            return Text(txt().lines()).bin()
        }

        fun octal(): String {
            return Text(txt().lines()).octal()
        }

        fun integer(): String {
            return Text(txt().lines()).integer()
        }
    }

    data class Oct(private val oct: List<String>) {
        fun txt(): String {
            val ss = StringBuffer()
            oct.forEach { line ->
                val cc = arrayListOf<String>()
                line.split(" ").forEach {
                    cc.add("${Integer.parseInt(it, 8).toChar()}")
                }
                ss.appendln(cc.toList().joinToString(""))
            }
            return ss.toString()
        }

        fun integer(): String {
            return Text(txt().lines()).integer()
        }

        fun bin(): String {
            return Text(txt().lines()).bin()
        }

        fun hex(): String {
            return Text(txt().lines()).hex()
        }
    }

    data class Int(private val int: List<String>) {
        fun txt(): String {
            val ss = StringBuffer()
            int.forEach { line ->
                val cc = arrayListOf<String>()
                line.split(" ").forEach {
                    cc.add("${ExpressionBuilder(it).build().evaluate().toBigDecimal().toInt().toChar()}")
                }
                ss.appendln(cc.toList().joinToString(""))
            }
            return ss.toString()
        }
        fun octal(): String {
            return Text(txt().lines()).octal()
        }

        fun bin(): String {
            return Text(txt().lines()).bin()
        }

        fun hex(): String {
            return Text(txt().lines()).hex()
        }
    }

    data class Decimal(private val dic:List<String>){
        fun bin(): String {
            val ss = StringBuffer()
            dic.forEach { line ->
                val cc = arrayListOf<String>()
                line.split(" ").forEach {
                   cc.add(doubleToBinary(
                        ExpressionBuilder(it).build().evaluate()
                   ))
                }
                ss.appendln(cc.toList().joinToString(" "))
            }
            return ss.toString()
        }
        private fun doubleToBinary(double: Double): String {
            var num = double
            val int = Integer.toBinaryString(num.toInt())
            val fraction = StringBuilder("")
            for (ss in 0..1000) {
                num = (num - num.toInt()) * 2 //For take the fraction after a point.
                if (num == 0.0) break
                fraction.append(num.toInt().absoluteValue)
            }
            return "$int.$fraction"
        }
    }
}
