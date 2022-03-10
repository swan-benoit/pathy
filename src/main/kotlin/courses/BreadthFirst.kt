package courses

import graph.GraphBaseDecorator
import graph.IGraph
import graph.Vertex
import java.util.*

data class BreadthFirstNode(var dist: Int, val node: Vertex, val previous: MutableMap<Vertex, Vertex> = mutableMapOf(), val shortestDistance: Int = -1)

class BreadthFirst(graph: IGraph) : GraphBaseDecorator(graph), ICourse {
    override fun course(from: Int, to: Int): String {
        val search = breadthFirstSearchPath(from, to)
            .previous
            .map { it.key.index.toString() }
            .toMutableList()
        search.add(to.toString())
        return search
            .toString()
    }

    fun breadthFirstSearchPath(start: Int, stop: Int): BreadthFirstNode {
        var previous = mutableMapOf<Vertex, Vertex>()
        var visited = vertexes.map { false }.toMutableList()
        var queue = mutableListOf<BreadthFirstNode>()
        val vertex = Vertex(start)
        queue.add(BreadthFirstNode(0,vertex))
        visited[start] = true

        while (queue.isNotEmpty()) {
            val currentNode = queue.removeFirst()
            if (currentNode.node.index === stop) {
                return BreadthFirstNode(currentNode.dist, currentNode.node, previous, currentNode.shortestDistance)
            }

            val children = Optional.ofNullable(vertexes[currentNode.node.index])

            children.ifPresent {
                for (child in it) {
                    if (!visited.get(child.index)) {
                        queue.add(BreadthFirstNode(currentNode.dist + 1, child))
                        visited[child.index] = true
                        previous.put(currentNode.node,child)
                    }
                }
            }
        }

        return BreadthFirstNode(-1, vertex, previous)
    }

}
