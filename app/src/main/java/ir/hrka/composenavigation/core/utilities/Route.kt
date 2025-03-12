package ir.hrka.composenavigation.core.utilities

interface Route {

    val destination: String


    fun appendArgs(vararg args: Any) =
        buildString {
            append(destination)

            args.forEach { arg ->
                append("/$arg")
            }
        }
}