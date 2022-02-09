package projet

import java.util.*

class Graph{
    val  vertexes: MutableMap<Int, MutableSet<Vertex>> = mutableMapOf();

    companion object {
        private var single: Graph? = null;
        fun getInstance(): Graph {
            if (single == null) {
                val matrix = Matrix(
                    listOf(
                        listOf(0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                        listOf(0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                        listOf(0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0),
                        listOf(0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1),
                        listOf(0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                        listOf(0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
                        listOf(0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0),
                        listOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0),
                        listOf(0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0),
                        listOf(0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                        listOf(0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0),
                        listOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                        listOf(0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0),
                        listOf(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0),
                        listOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
                    )
                )
                single = fromAdjencyMatrix(matrix)
            }
            return single as Graph;
        }

        fun fromAdjencyMatrix(matrix: Matrix): Graph{
            val graph = Graph()
            matrix.value.forEachIndexed {index, booleans -> graph.vertexes[index] = mutableSetOf() }
            for ((from,submatrix) in matrix.value.withIndex()) {
                for ((to,vertex) in submatrix.withIndex()) {
                    if (vertex == 1) {
                        val from = graph.vertexes[from]
                        from?.add(Vertex(to))
                    }
                }
            }
            return graph;
        }

        fun transitiveMatrixFromAdjacenyMatrix(matrix: Matrix): Matrix {
            val tranposeMatrix = matrix.transpose()
            return matrix.add(tranposeMatrix)
        }

    }

    fun getDegree(index: Int): Int? {
        return vertexes[index]?.size
    }

    fun breadthFirstSearch(start: Int): List<Vertex> {
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

    fun depthFirstSearch(start: Int,
                         result: MutableList<Vertex> = mutableListOf(),
                         visited: MutableList<Boolean> = vertexes.map { false }.toMutableList()): MutableList<Vertex>{
        result.add(Vertex(start))
        visited[start] = true

        Optional.ofNullable(vertexes[start])
            .ifPresent {
                it.filter { !visited[it.index] }
                    .forEach { depthFirstSearch(it.index, result, visited) }
            }

        return result
    }

    fun getAdjencyMatrix(): Matrix {
        var adjencyMatrix = MutableList(vertexes.size) { MutableList(vertexes.size) { 0 } }
        this.vertexes.forEach {
                row, destinations -> destinations.forEach { vertex ->  adjencyMatrix[row][vertex.index] = 1}
        }
        return Matrix(adjencyMatrix)
    }

}
