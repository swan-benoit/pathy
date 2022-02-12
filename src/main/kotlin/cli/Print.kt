package cli

import com.github.ajalt.clikt.core.CliktCommand
import graph.Graph
import displayer.GraphDisplayer

class Print: CliktCommand(help = "print the graph") {
    override fun run() {
        val graph = Graph.getInstance()
        val graphDisplayer = GraphDisplayer(graph)
        graphDisplayer.display()
    }
}
