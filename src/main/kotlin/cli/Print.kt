package cli

import com.github.ajalt.clikt.core.CliktCommand
import displayer.GraphDisplayer
import graph.GraphSingleton

class Print: CliktCommand(help = "print the graph") {
    override fun run() {
        val graph = GraphSingleton.getInstance()
        val graphDisplayer = GraphDisplayer(graph)
        graphDisplayer.display()
    }
}
