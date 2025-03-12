package ir.hrka.composenavigation.screens

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