package courses

import graph.GraphBaseDecorator
import graph.IGraph

class Diksktra(graph: IGraph) : GraphBaseDecorator(graph), ICourse {

    override fun course(from: Int, to: Int): String {
        return "1 - 2 - 3"
    }
}
