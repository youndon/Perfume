package appeanaLib

import com.example.demo.box.CodingList
import jdk.internal.org.objectweb.asm.Type.INT
import tornadofx.ItemViewModel
import java.util.*
import kotlin.math.absoluteValue
class Coding {
    companion object {


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

        // convert double to Converter.
         fun doubleToBinary(double: Double): String {
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