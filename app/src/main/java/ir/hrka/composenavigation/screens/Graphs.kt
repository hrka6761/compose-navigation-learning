package ir.hrka.composenavigation.screens

enum class Graphs(override val destination: String): Route {

    Main("main_graph"),
    Primary("primary_graph"),
    Secondary("secondary_graph");
}