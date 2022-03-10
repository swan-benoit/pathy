package cli

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.help
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.required
import com.github.ajalt.clikt.parameters.types.choice
import courses.BreadthFirst
import courses.Dijkstra
import graph.GraphSingleton

class Path: CliktCommand(help = "Calculate path") {
    val from by option()
        .choice(GraphSingleton.getInstance().nodeList())
        .required()
        .help("graph node where to start")
    val to by option()
        .choice(GraphSingleton.getInstance().nodeList())
        .required()
        .help("graph node where to arrive")
    override fun run() {

        val graph = GraphSingleton.getInstance()

        println("Dijkstra : "+ Dijkstra(graph)
            .course(this.from, this.to))

        println("Parcours en largeur modifié : " + BreadthFirst(graph)
            .course(this.from, this.to))

    }
}
