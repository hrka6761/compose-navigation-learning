package ir.hrka.composenavigation.core.utilities

sealed class Graphs(override val destination: String) : Route {

    object MainGraph : Graphs("main_graph")
    object PrimaryGraph : Graphs("primary_graph")
    object SecondaryGraph : Graphs("secondary_graph")
}