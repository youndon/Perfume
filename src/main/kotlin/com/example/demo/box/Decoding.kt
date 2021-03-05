package appeanaLib

import com.example.demo.box.CodingList
import net.objecthunter.exp4j.ExpressionBuilder

// ...
sealed class Decoding {
    object Binary : Decoding() {
        // convert the binary to text.
        // convert binary to double.
    }


    object Hex {
        // convert the hex to text.
    }

    object Octal {
        // covert the octal to text.


        // convert the integer to hex.
        internal fun integerToHex(nm: Int) = (Integer.toHexString(nm))

    }
}
