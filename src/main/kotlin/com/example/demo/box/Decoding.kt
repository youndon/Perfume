package appeanaLib

import com.example.demo.box.CodingList
import net.objecthunter.exp4j.ExpressionBuilder

// ...
sealed class Decoding {
    object Binary: Decoding() {
        // convert the binary to text.
        internal fun `binToText&Integer`(bin: List<String>): Pair<String, String> {
            val ss = Pair(StringBuffer(),StringBuffer())
            bin.forEach { line ->
                val cc = mutableMapOf<String,String>()
                line.split(" ").forEach {
                        cc.plusAssign("${Integer.parseInt(it, 2).toChar()}" to
                                          "${Integer.parseInt(it,2)}")
                    }
                ss.first.appendLine(cc.keys.toList().joinToString(""))
                ss.second.appendLine(cc.values.toList().joinToString(" "))
            }
            return Pair(ss.first.toString(),ss.second.toString())
        }
        // convert binary to double.
        internal fun binaryToDouble(bin: List<String>): String {
            val ss = StringBuffer()
            bin.forEach { lines ->
                val cc = arrayListOf<String>()
                lines.split(" ").forEach {line ->
                    val las0 = ExpressionBuilder(line).build().evaluate().toBigDecimal()
                        .toString().takeLast(line.toBigDecimal().scale()).toList()
                    val integerpart = CodingList().decreasing().zip(las0).filter { it.second == '1' }.sumByDouble { it.first }
                    val decimalpart = Integer.parseInt(line.substringBefore('.'), 2)
                    cc.add("${integerpart+decimalpart}")
                }
                ss.appendLine(cc.toList().joinToString(" "))
            }
            return ss.toString()
        }
        fun `binToHex&Octal`(bin: List<String>): Pair<String?,String?> {
           return Pair(Coding.`linesToText&Binary&Octal&Hex`(`binToText&Integer`(bin).first.lines()).first,
                        Coding.`linesToText&Binary&Octal&Hex`(`binToText&Integer`(bin).first.lines()).first )
        }
    }


    object Hex {
        // convert the hex to text.
        fun `hexToText&Integer`(hex: List<String>): Pair<String, String> {
            val ss = Pair(StringBuffer(),StringBuffer())
            hex.forEach { line ->
                val cc = mutableMapOf<String,String>()
                line.split(" ").forEach {
                    cc.plusAssign("${Integer.parseInt(it, 16).toChar()}" to
                                     "${Integer.parseInt(it, 16).toChar().toInt()}")
                }
                ss.first.appendLine(cc.keys.toList().joinToString(""))
                ss.second.appendLine(cc.values.toList().joinToString(" "))
            }
            return Pair(ss.first.toString(),ss.second.toString())
        }
        fun `hexToHex&Octal`(bin: List<String>): Pair<String?,String?> {
            return Pair(Coding.`linesToText&Binary&Octal&Hex`(`hexToText&Integer`(bin).first.lines()).second.third,
                Coding.`linesToText&Binary&Octal&Hex`(`hexToText&Integer`(bin).first.lines()).second.second )
        }
    }
        // covert the octal to text.
        internal fun octalToText(oct: String): String {
            try {
                oct.trimStart().trimEnd()
                    .split(" ")
                    .forEach {
                        it.trimStart()
                        val hex = Integer.parseInt(it, 8).toChar()
                        print(hex)
                    }
            } catch (e: Exception) {
            }
            return ""
        }

        // convert the integer to hex.
        internal fun integerToHex(nm: Int) = (Integer.toHexString(nm))

        // convert the octal to integer.
        internal fun octalToInteger(oct: Int) = Integer.parseInt(oct.toString(), 8)
}
