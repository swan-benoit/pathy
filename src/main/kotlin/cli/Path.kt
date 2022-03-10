package cli

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.help
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.required
import com.github.ajalt.clikt.parameters.types.choice
import courses.BreadthFirst
import courses.Dijkstra
import graph.GraphSingleton
import kotlin.system.measureTimeMillis

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

        val dijkstraBenchmark = measureTimeMillis {
            val dijkstraCourse = Dijkstra(graph)
                .course(this.from, this.to)
            print("Dijkstra : " + dijkstraCourse)
        }
        println(" temps d'execution : " + dijkstraBenchmark + " ms")

        val breadthFirstBenchmark = measureTimeMillis {
            val breadthFirstCourse = BreadthFirst(graph)
                .course(this.from, this.to)

            print("Parcours en largeur modifié : " + breadthFirstCourse)
        }
        println(" temps d'execution : " + breadthFirstBenchmark + " ms")

    }
}
