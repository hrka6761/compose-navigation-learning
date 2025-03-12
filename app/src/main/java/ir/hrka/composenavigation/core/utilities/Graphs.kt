package ir.hrka.composenavigation.core.utilities

enum class Graphs(override val destination: String): Route {

    Main("main_graph"),
    Primary("primary_graph"),
    Secondary("secondary_graph");
}