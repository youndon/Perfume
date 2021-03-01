package appeanaLib

import com.example.demo.box.CodingList
import java.util.*
import kotlin.math.absoluteValue

class Coding {
    companion object {

        fun `linesToText&Binary&Octal&Hex`(txt: List<String>): Pair<String, Triple<String, String, String>> {
            val ss = Pair(StringBuffer(),Triple(StringBuffer(),StringBuffer(),StringBuffer()))
            txt.forEach { line ->
                val cc = arrayListOf(mutableListOf(""),mutableListOf(""),mutableListOf(""),mutableListOf(""))
                line.forEach { it ->
                    cc[0].add("${it.toInt()}") // text
                    cc[1].add(Integer.toBinaryString(it.toInt())) // binary
                    cc[2].add(Integer.toOctalString(it.toInt())) // octal
                    cc[3].add(Integer.toHexString(it.toInt()).toUpperCase()) // hex
                }
                ss.first.appendLine(cc[0].toList().joinToString(""))
                ss.second.first.appendLine(cc[1].toList().joinToString(" "))
                ss.second.second.appendLine(cc[2].toList().joinToString(" "))
                ss.second.third.appendLine(cc[3].toList().joinToString(" "))
            }
            return Pair(ss.first.toString(),
                              Triple(ss.second.first.toString(),
                                     ss.second.second.toString(),
                                           ss.second.third.toString()))
        }

        // convert the integer to binary.
        // normal number.
        internal fun integerToBinary(nm: Int) = (Integer.toBinaryString(nm))

        // massive number:
        private val arr0 = CodingList().mounting()
        internal fun integerToBinary(num: String): Int {
            return if (num.length >= 31 && num.startsWith('1')) {
                num.takeLast(31)
                    .dropWhile { it == '1' }
                    .reversed()
                    .replace('0', '*').replace('1', '0').replace('*', '1')
                    .toList()
                    .zip(arr0)
                    .filter { it.first == '1' }
                    .sumBy { it.second.unaryMinus() }

            } else num.reversed()
                .toList()
                .zip(arr0)
                .filter { it.first == '1' }
                .sumBy { it.second.absoluteValue }
        }

        // convert the integer to octal.
        internal fun integerToOctal(nm: Int) = Integer.toOctalString(nm)

        // convert double to Binary.
        internal fun doubleToBinary(double: Double): String {
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