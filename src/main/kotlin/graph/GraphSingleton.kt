package graph

class GraphSingleton {
    companion object {
        var single: Graph? = null;
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
                        listOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0),
                        listOf(0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0),
                        listOf(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                        listOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
                    )
                )
                single = fromAdjencyMatrix(matrix)
            }
            return single as Graph;
        }

        fun fromAdjencyMatrix(matrix: Matrix): Graph {
            val graph = Graph()
            matrix.value.forEachIndexed { index, booleans -> graph.vertexes[index] = mutableSetOf() }
            for ((from, submatrix) in matrix.value.withIndex()) {
                for ((to, vertex) in submatrix.withIndex()) {
                    if (vertex == 1) {
                        val from = graph.vertexes[from]
                        from?.add(Vertex(to))
                    }
                }
            }
            return graph;
        }
    }
}
