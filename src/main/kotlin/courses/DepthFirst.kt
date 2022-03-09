package courses

import graph.GraphBaseDecorator
import graph.IGraph

class DepthFirst(graph: IGraph) : GraphBaseDecorator(graph), ICourse {
    override fun course(from: Int, to: Int): String {
        val search = depthFirstSearch(from, mutableListOf(), vertexes.map { false }.toMutableList())
            .map { it.index }

        return search
            .subList(0, search.indexOf(to) + 1)
            .toString()
    }
}
