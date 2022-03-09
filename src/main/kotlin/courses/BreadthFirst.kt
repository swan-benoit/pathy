package courses

import graph.GraphBaseDecorator
import graph.IGraph

class BreadthFirst(graph: IGraph) : GraphBaseDecorator(graph), ICourse {
    override fun course(from: Int, to: Int): String {
        return super.breadthFirstSearch(from)
            .subList(0, to + 1)
            .map { it.index }.toString()
    }
}
