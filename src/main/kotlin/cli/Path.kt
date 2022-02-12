package cli

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.help
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.types.choice
import graph.Graph

class Path: CliktCommand(help = "Calculate path") {
    val from by option().choice(Graph.getInstance().nodeList())
        .help("graph node where to start")
    val to by option()
        .choice(Graph.getInstance().nodeList())
        .help("graph node where to arrive")
    override fun run() {
        print("parcour")
    }
}
