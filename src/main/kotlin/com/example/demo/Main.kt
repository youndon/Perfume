import dyorgio.runtime.run.`as`.root.RootExecutor

fun main() {
//        HashCodeBuilder.reflectionHashCode("")
//    System.setProperty("java.library.path", "/usr/lib64/")

    RootExecutor("-Xmx64m").run {
        print("...")
    }

}

