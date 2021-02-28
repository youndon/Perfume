package appeanaLib

import com.example.demo.box.CodingList
import net.objecthunter.exp4j.ExpressionBuilder

// ...
sealed class Uncoding {
    object Binary {
        // convert the binary to text.
        internal fun binaryToText(bin: List<String>): String {
            val ss = StringBuffer()
            bin.forEach { lines ->
                val cc = arrayListOf<String>()
                lines.split(" ")
                    .forEach { line ->
                        line.trimStart()
                        cc.add("${Integer.parseInt(line, 2).toChar()}")
                    }
                ss.appendLine(cc.toList().joinToString(""))
            }
            return ss.toString()
        }
        // convert the binary to integer.
        @ExperimentalUnsignedTypes
        internal fun binaryToInteger(nm: List<String>): String {
            val ss = StringBuffer()
            nm.forEach { lines ->
                ss.appendLine(
                    Integer.parseInt(lines,2)
                        .toString().toList().joinToString("")
                )
            }
            return ss.toString()

        }
        // convert binary to double.
        internal fun binaryToDouble(bin: List<String>): String {
            val ss = StringBuffer()
            bin.forEach { lines ->
                val cc = arrayListOf<String>()
                lines.split(" ").forEach {line ->
                    val las0 = ExpressionBuilder(line).build().evaluate().toBigDecimal()
                        .toString().takeLast(line.toBigDecimal().scale()).toList()
                    val las1 = CodingList().decreasing().zip(las0).filter { it.second == '1' }.sumByDouble { it.first }
                    val las2 = Integer.parseInt(line.substringBefore('.'), 2)
                    cc.add("${las1+las2}")
                }
                ss.appendLine(cc.toList().joinToString(" "))
            }
            return ss.toString()
        }
    }


        // convert the hex to text.
        internal fun hexToText(hex: String ): String {
            try {
                hex.trimStart().trimEnd()
                        .split(" ")
                        .forEach {
                            it.trimStart()
                            val hex = Integer.parseInt(it, 16).toChar()
                            print(hex)
                        }
            } catch (e: Exception) {
                ops()
            }
            return ""
        }


        // covert the octal to text.
        internal fun octalToText(oct: String):String {
            try {
                oct.trimStart().trimEnd()
                   .split(" ")
                   .forEach {
                       it.trimStart()
                       val hex = Integer.parseInt(it, 8).toChar()
                       print(hex)
                   }
            } catch (e: Exception) {
                ops()
            }
            return ""
        }




        // convert the integer to hex.
        internal fun integerToHex(nm: Int) = (Integer.toHexString(nm))

        // convert the hex to integer.
        internal fun hexToInteger(hex: String): String {
            try {
                hex.trimStart().trimEnd()
                        .split(" ")
                        .forEach {
                            it.trimStart()
                            val hex = Integer.parseInt(it, 16).toChar().toInt()
                            print(hex)
                        }
            } catch (e: Exception) {
                ops()
            }
            return ""
        }

        // convert the octal to integer.
        internal fun octalToInteger(oct: Int) = Integer.parseInt(oct.toString(), 8)





       private fun ops() = println(("Ops! Something Wrong:("))
}
