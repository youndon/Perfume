package AppeanaFx.f

import tornadofx.Fragment
@Deprecated("don't have attachment!")
abstract class Fragment {
    lateinit var fragment: Fragment
    init {
        fragment
    }
}