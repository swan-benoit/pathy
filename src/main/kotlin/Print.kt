import com.github.ajalt.clikt.core.CliktCommand
import projet.Graph
import projet.GraphDisplayer
import projet.Matrix

class Print: CliktCommand(help = "print the graph") {
    override fun run() {
        val graph = Graph.getInstance()
        val graphDisplayer = GraphDisplayer(graph)
        graphDisplayer.display()
    }
}
