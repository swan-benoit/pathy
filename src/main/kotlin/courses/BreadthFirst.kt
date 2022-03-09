package courses

import graph.GraphBaseDecorator
import graph.IGraph

class BreadthFirst(graph: IGraph) : GraphBaseDecorator(graph), ICourse {
    override fun course(from: Int, to: Int): String {
        val search = breadthFirstSearch(from)
            .map { it.index }

        return search
            .subList(0, search.indexOf(to) + 1)
            .toString()
    }
}
