package courses

import graph.GraphBaseDecorator
import graph.IGraph
import graph.Vertex
import java.util.*

data class DijkstraNode(val destination: MutableSet<Vertex>,
                        var visited: Boolean = false,
                        var distanceFromSource: Double = Double.POSITIVE_INFINITY,
                        var bestParentFromSource: Int? = null,
)

class Dijkstra(graph: IGraph) : GraphBaseDecorator(graph), ICourse {
    var dijkstraCourse = super.vertexes
        .map { it.key to DijkstraNode(it.value) }
        .toMap()
        .toMutableMap()

    override fun course(from: Int, to: Int): String {
        dijkstraCourse(from, to)
        return buildCourseList(to)
    }

    private fun buildCourseList(to: Int): String {
        var currentNode = dijkstraCourse[to]
        var courseList = mutableListOf<Int>(to)
        while (currentNode != null) {
            val optional = Optional.ofNullable(currentNode.bestParentFromSource)
            if (optional.isEmpty) {
                currentNode = null
            } else {
                val nextNode = optional.get()
                courseList.add(nextNode)
                currentNode = dijkstraCourse[nextNode]
            }
        }

        courseList.reverse();
        return courseList.toString()
    }

    private fun dijkstraCourse(from: Int, to: Int) {
        dijkstraCourse[from]?.distanceFromSource = 0.0
        var currentNode = findUnvisitedMinimumDistanceFromSource()

        while (currentNode != null) {
            val dijkstraNode = currentNode.value
            dijkstraNode.visited = true
            for (children in dijkstraNode.destination) {
                val dijkstraNodeChildren = dijkstraCourse[children.index]
                if (dijkstraNodeChildren?.distanceFromSource!! > dijkstraNode.distanceFromSource) {
                    // Chemin optimal trouvé on le sauvegarde
                    dijkstraNodeChildren.distanceFromSource = dijkstraNode.distanceFromSource
                    dijkstraNodeChildren.bestParentFromSource = currentNode.key
                }
            }
            if (currentNode.key != to) {
                currentNode = findUnvisitedMinimumDistanceFromSource()
            } else {
                currentNode = null
            }
        }
    }

    private fun findUnvisitedMinimumDistanceFromSource() = dijkstraCourse
        .filterValues { !it.visited }
        .minByOrNull { it.value.distanceFromSource }
}
