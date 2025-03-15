package ir.hrka.composenavigation.core.utilities

enum class Graphs(override val destination: String): Route {

    MainGraph("main_graph"),
    PrimaryGraph("primary_graph"),
    SecondaryGraph("secondary_graph");
}