package appeanaLib

import com.example.demo.box.CodingList
import kotlin.math.absoluteValue

// ...
@Suppress("NAME_SHADOWING")
class Uncoding {

    companion object {


        // convert the binary to text.
        internal fun binaryToText(bin: String) :String {
            try {
                bin.trimEnd().trimStart()
                        .split(" ")
                   .forEach {
                       it.trimStart()
                       val binary = Integer.parseInt(it, 2).toChar()
                       print(binary)
                   }
            } catch (e: Exception) {
                ops()
            }
            return ""
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



        // convert the binary to integer.
        internal fun binaryToInteger(nm: Long) = (Integer.parseInt(nm.toString(), 2))

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



        // convert binary to double.
       internal fun binaryToDouble(bin: Double): Double {
            val las0 = bin.toString().takeLast(bin.toBigDecimal().scale()).toList()
            val las1 = CodingList().decreasing().zip(las0).filter { it.second == '1' }.sumByDouble { it.first }
            val las2 = Integer.parseInt(bin.toInt().toString(),2)
            return (las1 + las2)
        }

       private fun ops() = println(("Ops! Something Wrong:("))
    }
}
