package appeanaLib

import com.example.demo.box.CodingList
import java.util.*
import kotlin.math.absoluteValue

class Coding {
    companion object {
        // convert the text to binary, each line separately
        internal fun linesToBinary(text: List<String>): String {
            val ss = StringBuffer()
            text.forEach { lines ->  // all the lines.
                val cc = arrayListOf<String>()
                lines.forEach { line -> // for one single line.
                    cc.add(Integer.toBinaryString(line.toInt()))
                }
                ss.appendLine(cc.toList().joinToString(" "))
            }
            return ss.toString()
        }

        // convert the text to hex, each line separately
        internal fun linesToHex(text: List<String>): String {
            val ss = StringBuffer()
            text.forEach { lines ->
                val cc = arrayListOf<String>()
                lines.forEach {
                    cc.add(Integer.toHexString(it.toInt()).toUpperCase())
                }
                ss.appendLine(cc.toList().joinToString(" "))
            }
            return ss.toString()
        }

        // convert the text to octal, each line separately
        internal fun linesToOctal(text: List<String>): String {
            val ss = StringBuffer()
            text.forEach { lines ->
                val cc = arrayListOf<String>()
                lines.forEach {
                    cc.add(Integer.toOctalString(it.toInt()))
                }
                ss.appendLine(cc.toList().joinToString(" "))
            }
            return ss.toString()
        }

        // convert the text to integer, each line separately.
        fun linesToInteger(text: List<String>): String {
            val ss = StringBuffer()
            text.forEach { lines ->
                val cc = arrayListOf<Int>()
                lines.forEach { line ->
                    cc.add(line.toInt())
                }
                ss.appendLine(cc.toList().joinToString(" "))
            }
            return ss.toString()
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