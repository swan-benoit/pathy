package graph

import java.util.*

class Graph : IGraph {
    override val  vertexes: MutableMap<Int, MutableSet<Vertex>> = mutableMapOf();

    override fun getDegree(index: Int): Int? {
        return vertexes[index]?.size
    }

    override fun breadthFirstSearch(start: Int): List<Vertex> {
        var result = mutableListOf<Vertex>()
        var queue = mutableListOf<Vertex>()
        var visited = vertexes.map { false }.toMutableList()
        val vertex = Vertex(start)
        queue.add(vertex)
        result.add(vertex)
        visited[start] = true

        while (queue.isNotEmpty()){
            val currentNode = queue.removeFirst()
            val children = Optional.ofNullable(vertexes[currentNode.index])

            children.ifPresent {
                for (child in it){
                    if (!visited.get(child.index)){
                        queue.add(child)
                        visited[child.index] = true
                        result.add(child)
                    }
                }
            }
        }

        return result.toList()
    }

    override fun depthFirstSearch(start: Int,
                                  result: MutableList<Vertex>,
                                  visited: MutableList<Boolean>
    ): MutableList<Vertex>{
        result.add(Vertex(start))
        visited[start] = true

        Optional.ofNullable(vertexes[start])
            .ifPresent {
                it.filter { !visited[it.index] }
                    .forEach { depthFirstSearch(it.index, result, visited) }
            }

        return result
    }

    override fun getAdjencyMatrix(): Matrix {
        var adjencyMatrix = MutableList(vertexes.size) { MutableList(vertexes.size) { 0 } }
        this.vertexes.forEach {
                row, destinations -> destinations.forEach { vertex ->  adjencyMatrix[row][vertex.index] = 1}
        }
        return Matrix(adjencyMatrix)
    }

    override fun nodeList(): Map<String, String> {
        return this.vertexes
            .map { it.key.toString() to it.value.toString() }
            .toMap()
    }

}
